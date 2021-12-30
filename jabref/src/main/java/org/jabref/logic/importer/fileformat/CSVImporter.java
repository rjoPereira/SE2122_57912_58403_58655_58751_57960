package org.jabref.logic.importer.fileformat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jabref.logic.importer.Importer;
import org.jabref.logic.importer.ParserResult;
import org.jabref.logic.l10n.Localization;
import org.jabref.logic.util.StandardFileType;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.StandardEntryType;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.*;

/**
 * This class represents the CSV importer feature added during the project.
 * It allows the user to import more bibliographic references from a file
 * with csv extension into their JabRef application.
 *
 * @authors Clara Sousa, Paula Ines Lopes, Pedro Reis, Ricardo Pereira, Rita Silva
 */

public class CSVImporter extends Importer {

    @Override
    public String getId() { return "CSV"; }

    @Override
    public String getDescription() { return "Wraps the CSV function to be used as an Importer."; }

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
        throw new UnsupportedOperationException(
                "CSVImporter does not support importDatabase(BufferedReader reader)."
                        + "Instead use importDatabase(Path filePath, Charset defaultEncoding).");
    }

    @Override
    public ParserResult importDatabase(String data) throws IOException {
        throw new UnsupportedOperationException(
                "CSVImporter does not support importDatabase(String data)."
                        + "Instead use importDatabase(Path filePath, Charset defaultEncoding).");
    }

    /**
     * Gets a list of bibliographic references present in the given csv file,
     * provided that they have the format: Type,Author,Title,Year,Journal
     *
     * @param filePath path of the csv file
     * @return List<BibEntry> list of entries to be imported
     * @Pre: The provided path refers to a csv file format
     */
    public List<BibEntry> readCSV(Path filePath) {
        List<BibEntry> csvEntries = new ArrayList<>(100);
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

        for (CSVRecord csvRecord : records) {
            if (csvRecord.size() == 5) {
                entry = new BibEntry();
                entry.setType(StandardEntryType.valueOf(csvRecord.get(0)));
                entry.setField(StandardField.AUTHOR, csvRecord.get(1));
                entry.setField(StandardField.TITLE, csvRecord.get(2));
                entry.setField(StandardField.YEAR, csvRecord.get(3));
                entry.setField(StandardField.JOURNAL, csvRecord.get(4));

                csvEntries.add(entry);
            }
        }

        Collections.sort(csvEntries, (b1, b2) -> {
            Optional<String> author1 = b1.getField(StandardField.AUTHOR);
            Optional<String> author2 = b2.getField(StandardField.AUTHOR);
            if (author1.isPresent() && author2.isPresent()) {
                return author1.get().compareTo(author2.get());
            } else return 0;
        });

        return csvEntries;
    }

    /**
     * Imports the bibliographic references
     *
     * @param filePath        the path to the file which should be imported
     * @param defaultEncoding the text encoding being used
     * @return ParserResult parsed entries
     * @throws IOException if the list of entries is empty or if an I/O exception occurs.
     */
    @Override
    public ParserResult importDatabase(Path filePath, Charset defaultEncoding) throws IOException {
        Objects.requireNonNull(filePath);
        try {
            List<BibEntry> entries = readCSV(filePath);
            if (entries.isEmpty()) {
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
     * Checks whether the provided file path corresponds to a csv file
     *
     * @param filePath        the path of the file to check
     * @param defaultEncoding the text encoding being used
     * @return true if the file has a csv extension, false if otherwise
     * @throws IOException if an I/O exception occurs.
     */
    @Override
    public boolean isRecognizedFormat(Path filePath, Charset defaultEncoding) throws IOException {
        String fileExtension = filePath.toString().split("\\.")[1];
        boolean recognized = false;
        if (fileExtension.equals("csv")) recognized = true;

        return recognized;
    }

}
