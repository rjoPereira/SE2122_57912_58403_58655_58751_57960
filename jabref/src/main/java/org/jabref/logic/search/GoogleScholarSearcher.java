package org.jabref.logic.search;
import javafx.beans.binding.BooleanExpression;
import org.jabref.gui.DialogService;
import org.jabref.gui.JabRefFrame;
import org.jabref.gui.StateManager;
import org.jabref.gui.actions.SimpleCommand;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import static org.jabref.gui.actions.ActionHelper.isFieldSetForSelectedEntry;
import static org.jabref.gui.actions.ActionHelper.needsEntriesSelected;

/**
 * This class represents the Google Scholar feature added during the project.
 * It allows the user to find more bibliographic references from author(s) in their JabRef application.
 *
 * @authors Clara Sousa, Paula Ines Lopes, Pedro Reis, Ricardo Pereira, Rita Silva
 */
public class GoogleScholarSearcher extends SimpleCommand {
    private static final String GOOGLE_SCHOLAR_ADDR = "https://scholar.google.com/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36";
    private static final String REFERRER = "https://www.google.com/";
    private static final String WARNING = "Warning";

    private String url;
    private Document doc;
    private int currentAuthor;
    private String[] authors;
    private final JabRefFrame jabRefFrame;
    private final DialogService dialogService;

    public GoogleScholarSearcher(BibEntry entry, DialogService dialogService, JabRefFrame jabRefFrame, StateManager stateManager) {
        this.jabRefFrame = jabRefFrame;
        this.dialogService = dialogService;
        BooleanExpression fieldIsSet = isFieldSetForSelectedEntry(StandardField.AUTHOR, stateManager);
        Optional<String> author = entry.getField(StandardField.AUTHOR);
        if(author.isPresent()) this.authors = author.get().split(";");
        this.currentAuthor = 0;
        this.executable.bind(needsEntriesSelected(1, stateManager).and(fieldIsSet));
    }

    /**
     * Gets the Google Scholar associated profile of an author.
     *
     * @return url of the Google Scholar profile or null if the author does not exist in the Google Scholar.
     * @throws IOException if an I/O exception occurs.
     */
    private String getUrl() throws IOException {
        String[] name = authors[currentAuthor].split(" ");

        Document auxDoc;
        StringBuilder sb = new StringBuilder();
        String searchURL = GOOGLE_SCHOLAR_ADDR + "scholar?hl=en&as_sdt=0%2C5&q=";
        sb.append(searchURL);
        for(int i = 0; i < name.length; i++){
            sb.append(name[i]);
            if(i != name.length - 1)
                sb.append("+");
        }

        sb.append("&btnG=");

        auxDoc = Jsoup.connect(sb.toString()).userAgent(USER_AGENT).referrer(REFERRER).get();

        Elements authorsName = auxDoc.getElementsByClass("gs_rt2");

        for (int i = 0; i < authorsName.size(); i++){
            if(authorsName.get(i).text().equalsIgnoreCase(authors[currentAuthor])){
                return GOOGLE_SCHOLAR_ADDR + authorsName.get(i).getElementsByTag("a").get(0).attr("href");
            }
        }

        return null;
    }

    /**
     * Gets the article titles for a maximum of 10 articles.
     *
     * @return List<String> titles
     */
    private List<String> getTitles(){
        List<String> titles = new ArrayList<>(10);

        Elements titlesElems = doc.getElementsByClass("gsc_a_at");
        Iterator<Element> it = titlesElems.iterator();

        while(it.hasNext() && titles.size() < 10){
            Element titleElem = it.next();
            titles.add(titleElem.text());
        }

        return titles;
    }

    /**
     * Gets the publication years for a maximum of 10 articles.
     *
     * @return List<String> publication years
     */
    private List<String> getYears(){
        List<String> years = new ArrayList<>(10);

        Elements yearsClasses = doc.select(".gsc_a_y .gsc_a_h.gsc_a_hc.gs_ibl");
        Iterator<Element> it = yearsClasses.iterator();

        while(it.hasNext() && years.size() < 10){
            Element year = it.next();
            years.add(year.text());
        }

        return years;
    }

    /**
     * Gets the journal titles for a maximum of 10 articles.
     *
     * @return List<String> journal titles
     */
    private List<String> getJournal(){
        List<String> journals = new ArrayList<>(10);

        Elements journalsClasses = doc.select(".gsc_a_t div.gs_gray");
        int firstJournal = 1;
        Iterator<Element> it = journalsClasses.iterator();

        while(it.hasNext() && journals.size() < 10){
            try{
                String journal = journalsClasses.get(firstJournal).text().split(", ")[0];
                journals.add(journal);
                firstJournal += 2;
            }catch (IndexOutOfBoundsException e){
                break;
            }
        }

        return journals;
    }

    /**
     * Gets the set of new entries to be added to the JabRef library.
     *
     * @return List<BibEntry> entries
     */
    private List<BibEntry> getEntries(List<BibEntry> entries, int limit) throws IOException {
        List<String> titles = getTitles();
        List<String> years = getYears();
        List<String> journals = getJournal();
        int pos = 0;
        int i = 0;
        try {
            for(i = 0; i < limit; i++) {
                BibEntry entry = new BibEntry();
                entry.setType(StandardEntryType.Article);
                entry.setField(StandardField.AUTHOR, authors[currentAuthor]);
                entry.setField(StandardField.TITLE, titles.get(pos));
                entry.setField(StandardField.YEAR, years.get(pos));
                entry.setField(StandardField.JOURNAL, journals.get(pos));
                ++pos;
                entries.add(entry);
            }
        }catch(IndexOutOfBoundsException e){
            currentAuthor++;
            while(currentAuthor < authors.length){
                this.url = getUrl();
                if (url!=null) {
                    break;
                } else currentAuthor++;
            }
            if(currentAuthor < authors.length){
                this.doc = Jsoup.connect(this.url).userAgent(USER_AGENT).referrer(REFERRER).get();
                getEntries(entries, limit-i);
            }else
                dialogService.showWarningDialogAndWait(Localization.lang(WARNING),
                    Localization.lang("Only " + i + " entries were found."));
        }


        return entries;
    }

    /**
     * Adds the set of new entries to the JabRef application.
     */
    @Override
    public void execute() {
        try {
            this.url = getUrl();
            while(url == null && currentAuthor < authors.length) {
                currentAuthor++;
                this.url = getUrl();
            }
            doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
            List<BibEntry> entries = new ArrayList<>(10);
            jabRefFrame.getCurrentLibraryTab().insertEntries(getEntries(entries, 10));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch(IllegalArgumentException e2) {
            dialogService.showWarningDialogAndWait(Localization.lang(WARNING),
                    Localization.lang(e2.getMessage()+". Could not find author(s)."));
        }
    }
}
