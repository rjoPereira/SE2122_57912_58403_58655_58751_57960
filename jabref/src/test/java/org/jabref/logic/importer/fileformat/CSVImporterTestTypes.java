package org.jabref.logic.importer.fileformat;

import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.EntryType;
import org.jabref.model.entry.types.StandardEntryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVImporterTestTypes {
    @Test
    public void importConvertsToCorrectBibType() throws IOException {
       Path p = Paths.get("C:", "Users", "Rita", "RC", "jabref", "example.csv");
       CSVImporter csvImp = new CSVImporter();

       List<BibEntry> bibEntries = csvImp.importDatabase(p, Charset.defaultCharset())
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
