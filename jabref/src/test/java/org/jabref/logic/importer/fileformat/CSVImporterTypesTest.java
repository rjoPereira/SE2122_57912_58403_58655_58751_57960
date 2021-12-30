package org.jabref.logic.importer.fileformat;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class CSVImporterTypesTest {
    @Test
    void importConvertsToCorrectBibType() throws IOException {

       Path p = Paths.get("").toAbsolutePath();
       Path finalP = Paths.get(p.toString(), "src", "test", "java", "org", "jabref", "logic", "importer", "fileformat", "example.csv");
       System.out.println("class path currently : " + finalP.toString());
       CSVImporter csvImp = new CSVImporter();

       List<BibEntry> bibEntries = csvImp.importDatabase(finalP, Charset.defaultCharset())
                .getDatabase().getEntries();

        BibEntry entry = new BibEntry();
        entry.setField(StandardField.AUTHOR, "Ze");
        entry.setField(StandardField.TITLE, "A casinha do ze");
        entry.setField(StandardField.YEAR, "2021");
        entry.setField(StandardField.JOURNAL, "querido mudei a casa");
        entry.setType(StandardEntryType.Article);

        Assertions.assertEquals(Collections.singletonList(entry), bibEntries);
    }
}
