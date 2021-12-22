package org.jabref.logic.search;

import org.jabref.model.entry.BibEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class GoogleScholarSearcher {
    String url;

    public GoogleScholarSearcher(String authorName){
        String[] name = authorName.split("\\s+");
        String url = "https://scholar.google.com/scholar?hl=en&as_sdt=0%2C5&q=" + name[0] + "+"+ name[1] + "&btnG=";
        Document doc = connect();
    }

    private Document connect(){
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        }catch(IOException e) {
            return null;
        }

        return doc;
    }

    private ArrayList<BibEntry> getEntries(){

        return null;
    }
}
