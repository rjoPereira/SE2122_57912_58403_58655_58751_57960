package org.jabref.logic.search;

import org.jabref.gui.actions.SimpleCommand;
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

public class GoogleScholarSearcher extends SimpleCommand {
    private static final String GOOGLE_SCHOLAR_ADDR = "https://scholar.google.com/";

    String url;
    Document doc;
    String authorName;

    public GoogleScholarSearcher(String authorName) throws IOException {
        this.authorName = authorName;
        url = getUrl();
        doc = Jsoup.connect(url).get();
        System.out.println(doc.body());

    }

    private String getUrl() throws IOException {
        String[] name = authorName.split(" ");
        Document doc;
        String searchURL = GOOGLE_SCHOLAR_ADDR + "scholar?hl=en&as_sdt=0%2C5&q="+name[0]+"+"+name[1]+"&btnG=";
        doc = Jsoup.connect(searchURL).get();

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

        Elements yearsClasses = doc.select(".gsc_a_t div.gs_gray");
        int firstYear = 1;
        Iterator<Element> it = yearsClasses.iterator();

        while(it.hasNext() && years.size() < 10){
            String year = yearsClasses.get(firstYear).text().split(", ")[1];
            years.add(year);
            firstYear += 2;
        }

        return years;
    }

    private List<String> getJournal(){
        List<String> journals = new ArrayList<>(10);

        Elements journalsClasses = doc.select(".gsc_a_t div.gs_gray");
        int firstJournal = 0;
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
        }

        return entries;
    }

    @Override
    public void execute() {

    }
}
