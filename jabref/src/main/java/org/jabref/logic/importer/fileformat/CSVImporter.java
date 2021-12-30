package org.jabref.logic.importer.fileformat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jabref.logic.JabRefException;
import org.jabref.logic.importer.ImportException;
import org.jabref.logic.importer.Importer;
import org.jabref.logic.importer.ParserResult;
import org.jabref.logic.l10n.Localization;
import org.jabref.logic.util.StandardFileType;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.Field;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.*;

public class CSVImporter extends Importer {
    @Override
    public String getName() {
        return "CSV";
    }

    @Override
    public StandardFileType getFileType() {
        return StandardFileType.CSV;
    }

    @Override
    public ParserResult importDatabase(BufferedReader reader) throws IOException {
        //Objects.requireNonNull(reader);
        throw new UnsupportedOperationException(
                "CSVImporter does not support importDatabase(BufferedReader reader)."
                        + "Instead use importDatabase(Path filePath, Charset defaultEncoding).");
    }

    @Override
    public ParserResult importDatabase(String data) throws IOException {
        //Objects.requireNonNull(data);
        throw new UnsupportedOperationException(
                "CSVImporter does not support importDatabase(String data)."
                        + "Instead use importDatabase(Path filePath, Charset defaultEncoding).");
    }

    public ArrayList<BibEntry> readCSV(Path filePath) {
        ArrayList<BibEntry> csvEntries = new ArrayList<>(100);
        Reader csv;

        try {
            csv = new FileReader(filePath.toString());
        } catch (FileNotFoundException e) {
            return csvEntries;
        }

        Iterable<CSVRecord> records;

        try {
            records = CSVFormat.DEFAULT.parse(csv);
        } catch (IOException e) {
            return csvEntries;
        }

        BibEntry entry;

        for (CSVRecord record : records) {
            if (record.size() == 5) {
                entry = new BibEntry();
                entry.setType(StandardEntryType.valueOf(record.get(0)));
                entry.setField(StandardField.AUTHOR, record.get(1));
                entry.setField(StandardField.TITLE, record.get(2));
                entry.setField(StandardField.YEAR, record.get(3));
                entry.setField(StandardField.JOURNAL, record.get(4));

                csvEntries.add(entry);
            }
        }

        Collections.sort(csvEntries, new Comparator<BibEntry>() {
            public int compare(BibEntry b1, BibEntry b2) {
                return b1.getField(StandardField.AUTHOR).get().compareTo(b2.getField(StandardField.AUTHOR).get());
            }
        });

        return csvEntries;
    }

    @Override
    public ParserResult importDatabase(Path filePath, Charset defaultEncoding) throws IOException {
        Objects.requireNonNull(filePath);
        try {
            ArrayList<BibEntry> entries = readCSV(filePath);
            if (entries.size() == 0) {
                throw new IOException();
            } else {
                return new ParserResult(entries);
            }
        } catch (IOException e) {
            throw new IOException(Localization.lang("Could not find any entries in the correct format. Please make sure your entries are in the following format: Type,Author,Title,Year,Journal"));
        }
    }

    @Override
    public boolean isRecognizedFormat(BufferedReader reader) throws IOException {
        Objects.requireNonNull(reader);
        return true;
    }

    /**
     * Returns whether the given stream contains data that is a.) a CSV and b.)
     * contains at least one BibEntry.
     */
    @Override
    public boolean isRecognizedFormat(Path filePath, Charset defaultEncoding) throws IOException {
        String fileExtension = filePath.toString().split("\\.")[1];

        if (fileExtension.equals("csv"))
            return true;
        else
            return false;
    }

    @Override
    public String getId() {
        return "CSV";
    }

    @Override
    public String getDescription() {
        return "Wraps the CSV function to be used as an Importer.";
    }
}
