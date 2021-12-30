package org.jabref.logic.importer.fileformat;

import org.jabref.logic.util.StandardFileType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CSVImporterTest {

    private CSVImporter importer;

    @BeforeEach
    void setUp() throws Exception {
        importer = new CSVImporter();
    }

    @Test
    void testGetFormatName() {
        assertEquals("CSV", importer.getName());
    }

    @Test
    void testGetCLIId() {
        assertEquals("CSV", importer.getId());
    }

    @Test
    void testsGetExtensions() {
        assertEquals(StandardFileType.CSV, importer.getFileType());
    }

    @Test
    void testGetDescription() {
        assertEquals("Wraps the CSV function to be used as an Importer.", importer.getDescription());
    }

}
