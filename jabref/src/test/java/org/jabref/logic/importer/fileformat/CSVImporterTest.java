package org.jabref.logic.importer.fileformat;

import org.jabref.logic.util.StandardFileType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CSVImporterTest {

    private CSVImporter importer;

    @BeforeEach
    public void setUp() throws Exception {
        importer = new CSVImporter();
    }

    @Test
    public void testGetFormatName() {
        assertEquals("CSV", importer.getName());
    }

    @Test
    public void testGetCLIId() {
        assertEquals("CSV", importer.getId());
    }

    @Test
    public void testsGetExtensions() {
        assertEquals(StandardFileType.CSV, importer.getFileType());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Wraps the CSV function to be used as an Importer.", importer.getDescription());
    }
    
}
