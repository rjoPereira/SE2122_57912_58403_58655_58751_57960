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


public class GoogleScholarSearcher extends SimpleCommand {
    private static final String GOOGLE_SCHOLAR_ADDR = "https://scholar.google.com/";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36";
    private static final String REFERRER = "https://www.google.com/";

    String url;
    Document doc;
    String authorName;
    private final JabRefFrame jabRefFrame;
    private final DialogService dialogService;

    public GoogleScholarSearcher(BibEntry entry, DialogService dialogService, JabRefFrame jabRefFrame, StateManager stateManager) throws IOException {
        this.jabRefFrame = jabRefFrame;
        this.dialogService = dialogService;
        BooleanExpression fieldIsSet = isFieldSetForSelectedEntry(StandardField.AUTHOR, stateManager);
        Optional<String> author = entry.getField(StandardField.AUTHOR);
        if(author.isPresent()) this.authorName = author.get();
        this.executable.bind(needsEntriesSelected(1, stateManager).and(fieldIsSet));
    }

    private String getUrl() throws IOException {
        String[] name = authorName.split(" ");

        Document doc;
        String searchURL = GOOGLE_SCHOLAR_ADDR + "scholar?hl=en&as_sdt=0%2C5&q=";

        for(int i = 0; i < name.length; i++){
            searchURL += name[i];
            if(i != name.length - 1)
                searchURL += "+";
        }

        searchURL += "&btnG=";

        doc = Jsoup.connect(searchURL).userAgent(USER_AGENT).referrer(REFERRER).get();

        Elements authorsName = doc.getElementsByClass("gs_rt2");

        for (int i = 0; i < authorsName.size(); i++){
            if(authorsName.get(i).text().equalsIgnoreCase(authorName)){
                return GOOGLE_SCHOLAR_ADDR + authorsName.get(i).getElementsByTag("a").get(0).attr("href");
            }
        }

        return null;
    }

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

    private List<String> getJournal(){
        List<String> journals = new ArrayList<>(10);

        Elements journalsClasses = doc.select(".gsc_a_t div.gs_gray");
        int firstJournal = 1;
        Iterator<Element> it = journalsClasses.iterator();

        while(it.hasNext() && journals.size() < 10){
            String journal = journalsClasses.get(firstJournal).text().split(", ")[0];
            journals.add(journal);
            firstJournal += 2;
        }

        return journals;
    }

    private List<BibEntry> getEntries(){
        List<BibEntry> entries = new ArrayList<>(10);
        List<String> titles = getTitles();
        List<String> years = getYears();
        List<String> journals = getJournal();

        for(int i = 0; i < titles.size(); i++){
            BibEntry entry = new BibEntry();
            entry.setType(StandardEntryType.Article);
            entry.setField(StandardField.AUTHOR, authorName);
            entry.setField(StandardField.TITLE, titles.get(i));
            entry.setField(StandardField.YEAR, years.get(i));
            entry.setField(StandardField.JOURNAL, journals.get(i));
            entries.add(entry);
        }

        return entries;
    }

    @Override
    public void execute() {
        try {
            url = getUrl();
            System.out.println(url);
            doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
            jabRefFrame.getCurrentLibraryTab().insertEntries(getEntries());
        } catch (IOException e) {
            e.printStackTrace();
        } catch(IllegalArgumentException e) {
            dialogService.showWarningDialogAndWait(Localization.lang("Warning"),
                    Localization.lang(e.getMessage()+". Author not found."));
        }
    }
}
