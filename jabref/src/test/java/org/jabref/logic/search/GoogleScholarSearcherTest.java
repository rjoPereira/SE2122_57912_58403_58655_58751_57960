package org.jabref.logic.search;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoogleScholarSearcherTest {
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36";
    private static final String REFERRER = "https://www.google.com/";

    @Test
    void testTitles() {
        String url = "https://scholar.google.com/citations?hl=pt-PT&user=ReF98QcAAAAJ";//Joao Leite

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> titlesFromScraper = new ArrayList<>(10);

        Elements titlesElems = doc.getElementsByClass("gsc_a_at");
        Iterator<Element> it = titlesElems.iterator();

        while (it.hasNext() && titlesFromScraper.size() < 10) {
            Element titleElem = it.next();
            titlesFromScraper.add(titleElem.text());
        }

        List<String> fromGoogleScholar = new ArrayList<String>(10);
        fromGoogleScholar.add("A survey of programming languages and platforms for multi-agent systems");
        fromGoogleScholar.add("Dynamic updates of non-monotonic knowledge bases");
        fromGoogleScholar.add("Social abstract argumentation");
        fromGoogleScholar.add("Evolving logic programs");
        fromGoogleScholar.add("Dynamic logic programming");
        fromGoogleScholar.add("Evolving knowledge bases");
        fromGoogleScholar.add("Germline MUTYH (MYH) mutations in Portuguese individuals with multiple colorectal adenomas");
        fromGoogleScholar.add("MINERVA - A Dynamic Logic Programming Agent Architecture");
        fromGoogleScholar.add("Generalizing updates: from models to programs");
        fromGoogleScholar.add("The refined extension principle for semantics of dynamic logic programming");

        assertEquals(fromGoogleScholar, titlesFromScraper);
    }

    @Test
    void testGetJournals() {
        String url = "https://scholar.google.com/citations?hl=pt-PT&user=ReF98QcAAAAJ";// Joao Leite
        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> journals = new ArrayList<>(10);

        Elements journalsClasses = doc.select(".gsc_a_t div.gs_gray");
        int firstJournal = 1;

        System.out.println(journalsClasses.size());
        while (journals.size() < 10) {
            try {
                String journal = journalsClasses.get(firstJournal).text().split(", ")[0];
                journals.add(journal);
                firstJournal += 2;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        List<String> fromGoogleScholar = new ArrayList<String>(10);
        fromGoogleScholar.add("Informatica 30 (1)");
        fromGoogleScholar.add("The journal of logic programming 45 (1-3)");
        fromGoogleScholar.add("Twenty-Second International Joint Conference on Artificial Intelligence");
        fromGoogleScholar.add("European Workshop on Logics in Artificial Intelligence");
        fromGoogleScholar.add("Principles of Knowledge Representation and Reasoning (KR'98)");
        fromGoogleScholar.add("IOS press");
        fromGoogleScholar.add("Human mutation 24 (4)");
        fromGoogleScholar.add("Intelligent Agents VIII");
        fromGoogleScholar.add("Logic Programming and Knowledge Representation");
        fromGoogleScholar.add("Studia Logica 79 (1)");

        assertEquals(fromGoogleScholar, journals);
    }

    @Test
    void getYears() {
        String url = "https://scholar.google.com/citations?hl=pt-PT&user=ReF98QcAAAAJ";// Joao Leite
        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> years = new ArrayList<>(10);

        Elements yearsClasses = doc.select(".gsc_a_y .gsc_a_h.gsc_a_hc.gs_ibl");
        Iterator<Element> it = yearsClasses.iterator();

        while (it.hasNext() && years.size() < 10) {
            Element year = it.next();
            years.add(year.text());
        }

        List<String> fromGoogleScholar = new ArrayList<String>(10);
        fromGoogleScholar.add("2006");
        fromGoogleScholar.add("2000");
        fromGoogleScholar.add("2011");
        fromGoogleScholar.add("2002");
        fromGoogleScholar.add("1998");
        fromGoogleScholar.add("2003");
        fromGoogleScholar.add("2004");
        fromGoogleScholar.add("2002");
        fromGoogleScholar.add("1998");
        fromGoogleScholar.add("2005");

        assertEquals(fromGoogleScholar, years);

    }

    @Test
    void testGetEntries() {
        List<String> urls = new ArrayList<String>(2);
        urls.add("https://scholar.google.com/citations?user=TwV6ZecAAAAJ&hl=pt-PT&oi=ao"); //Pedro Fouto
        urls.add("https://scholar.google.com/citations?hl=pt-PT&user=ReF98QcAAAAJ"); //Joao Leite
        String[] authors = {"Pedro Fouto", "Joao Leite"};
        Document doc = null;
        int pos = 0;
        int currentAuthor = 0;
        try {
            doc = Jsoup.connect(urls.get(currentAuthor)).userAgent(USER_AGENT).referrer(REFERRER).get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<BibEntry> entries = new ArrayList<>(10);
        List<String> titles = new ArrayList<>(10);
        Elements titlesElems = doc.getElementsByClass("gsc_a_at");
        Iterator<Element> it = titlesElems.iterator();

        while (it.hasNext() && titles.size() < 10) {
            Element titleElem = it.next();
            titles.add(titleElem.text());
        }

        List<String> years = new ArrayList<>(10);
        Elements yearsClasses = doc.select(".gsc_a_y .gsc_a_h.gsc_a_hc.gs_ibl");
        Iterator<Element> it2 = yearsClasses.iterator();

        while (it2.hasNext() && years.size() < 10) {
            Element year = it2.next();
            years.add(year.text());
        }

        List<String> journals = new ArrayList<>(10);
        Elements journalsClasses = doc.select(".gsc_a_t div.gs_gray");
        int firstJournal = 1;
        Iterator<Element> it3 = journalsClasses.iterator();

        while (it3.hasNext() && journals.size() < 10) {
            try {
                String journal = journalsClasses.get(firstJournal).text().split(", ")[0];
                journals.add(journal);
                firstJournal += 2;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            try {
                BibEntry entry = new BibEntry();
                entry.setType(StandardEntryType.Article);
                entry.setField(StandardField.AUTHOR, authors[currentAuthor]);
                entry.setField(StandardField.TITLE, titles.get(pos));
                entry.setField(StandardField.YEAR, years.get(pos));
                entry.setField(StandardField.JOURNAL, journals.get(pos));
                ++pos;
                entries.add(entry);
            } catch (IndexOutOfBoundsException e) {
                try {
                    ++currentAuthor;
                    if (currentAuthor < authors.length) {
                        doc = Jsoup.connect(urls.get(currentAuthor)).userAgent(USER_AGENT).referrer(REFERRER).get();
                    } else
                        break;
                } catch (IOException e2) {
                    break;
                } catch (IllegalArgumentException e3) {
                    break;
                }

                titles.clear();
                Elements titlesElems2 = doc.getElementsByClass("gsc_a_at");
                Iterator<Element> it4 = titlesElems2.iterator();

                while (it4.hasNext() && titles.size() < 10) {
                    Element titleElem = it4.next();
                    titles.add(titleElem.text());
                }

                years.clear();
                Elements yearsClasses2 = doc.select(".gsc_a_y .gsc_a_h.gsc_a_hc.gs_ibl");
                Iterator<Element> it5 = yearsClasses2.iterator();

                while (it5.hasNext() && years.size() < 10) {
                    Element year = it5.next();
                    years.add(year.text());
                }

                journals.clear();
                Elements journalsClasses2 = doc.select(".gsc_a_t div.gs_gray");
                firstJournal = 1;
                Iterator<Element> it6 = journalsClasses2.iterator();

                while (it6.hasNext() && journals.size() < 10) {
                    try {
                        String journal = journalsClasses2.get(firstJournal).text().split(", ")[0];
                        journals.add(journal);
                        firstJournal += 2;
                    } catch (IndexOutOfBoundsException e2) {
                        break;
                    }
                }
                --i;
                pos = 0;
            }
        }

        List<BibEntry> fromGoogleScholar2 = new ArrayList<>(10);

        BibEntry entry0 = new BibEntry();
        BibEntry entry1 = new BibEntry();
        BibEntry entry2 = new BibEntry();
        BibEntry entry3 = new BibEntry();
        BibEntry entry4 = new BibEntry();
        BibEntry entry5 = new BibEntry();
        BibEntry entry6 = new BibEntry();
        BibEntry entry7 = new BibEntry();
        BibEntry entry8 = new BibEntry();
        BibEntry entry9 = new BibEntry();

        entry0.setType(StandardEntryType.Article);
        entry0.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry0.setField(StandardField.YEAR, "2017");
        entry0.setField(StandardField.TITLE, "Legion: Enriching internet services with peer-to-peer interactions");
        entry0.setField(StandardField.JOURNAL, "Proceedings of the 26th International Conference on World Wide Web");

        fromGoogleScholar2.add(entry0);

        entry1.setType(StandardEntryType.Article);
        entry1.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry1.setField(StandardField.YEAR, "2018");
        entry1.setField(StandardField.TITLE, "Practical and fast causal consistent partial geo-replication");
        entry1.setField(StandardField.JOURNAL, "2018 IEEE 17th International Symposium on Network Computing and Applications …");

        fromGoogleScholar2.add(entry1);

        entry2.setType(StandardEntryType.Article);
        entry2.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry2.setField(StandardField.YEAR, "2020");
        entry2.setField(StandardField.TITLE, "Overlay Networks for Edge Management");
        entry2.setField(StandardField.JOURNAL, "2020 IEEE 19th International Symposium on Network Computing and Applications …");

        fromGoogleScholar2.add(entry2);


        entry3.setType(StandardEntryType.Article);
        entry3.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry3.setField(StandardField.YEAR, "2020");
        entry3.setField(StandardField.TITLE, "The intrinsic cost of causal consistency");
        entry3.setField(StandardField.JOURNAL, "Proceedings of the 7th Workshop on Principles and Practice of Consistency …");

        fromGoogleScholar2.add(entry3);

        entry4.setType(StandardEntryType.Article);
        entry4.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry4.setField(StandardField.YEAR, "2018");
        entry4.setField(StandardField.TITLE, "A novel causally consistent replication protocol with partial geo-replication");
        //

        fromGoogleScholar2.add(entry4);

        entry5.setType(StandardEntryType.Article);
        entry5.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry5.setField(StandardField.YEAR, "2017");
        entry5.setField(StandardField.TITLE, "A novel causally consistent datastore with dynamic partial replication");
        entry5.setField(StandardField.JOURNAL, "Faculdade de Ciências e Tecnologia");

        fromGoogleScholar2.add(entry5);

        entry6.setType(StandardEntryType.Article);
        entry6.setField(StandardField.AUTHOR, "Pedro Fouto");
        entry6.setField(StandardField.YEAR, "");
        entry6.setField(StandardField.TITLE, "Difusão Causal Flexível e Escalável para Replicação na Periferia");


        fromGoogleScholar2.add(entry6);

        entry7.setType(StandardEntryType.Article);
        entry7.setField(StandardField.AUTHOR, "Joao Leite");
        entry7.setField(StandardField.YEAR, "2006");
        entry7.setField(StandardField.TITLE, "A survey of programming languages and platforms for multi-agent systems");
        entry7.setField(StandardField.JOURNAL, "Informatica 30 (1)");

        fromGoogleScholar2.add(entry7);

        entry8.setType(StandardEntryType.Article);
        entry8.setField(StandardField.AUTHOR, "Joao Leite");
        entry8.setField(StandardField.YEAR, "2000");
        entry8.setField(StandardField.TITLE, "Dynamic updates of non-monotonic knowledge bases");
        entry8.setField(StandardField.JOURNAL, "The journal of logic programming 45 (1-3)");

        fromGoogleScholar2.add(entry8);

        entry9.setType(StandardEntryType.Article);
        entry9.setField(StandardField.AUTHOR, "Joao Leite");
        entry9.setField(StandardField.YEAR, "2011");
        entry9.setField(StandardField.TITLE, "Social abstract argumentation");
        entry9.setField(StandardField.JOURNAL, "Twenty-Second International Joint Conference on Artificial Intelligence");

        fromGoogleScholar2.add(entry9);

        assertEquals(fromGoogleScholar2, entries);
    }
}
