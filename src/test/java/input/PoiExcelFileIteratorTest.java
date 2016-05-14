package input;

import org.junit.Test;

import java.io.InputStream;
import java.util.Iterator;

import static org.junit.Assert.*;

public class PoiExcelFileIteratorTest {

    @Test
    public void testOneRowXLSXFile() {
        testSimpleRow(this.getClass().getResourceAsStream("oneRow.xlsx"));
    }

    @Test
    public void testOneRowXLSFile() {
        testSimpleRow(this.getClass().getResourceAsStream("oneRow.xls"));
    }

    @Test
    public void testXLSXSimplePRicelist() {
        testSimplePriceList(this.getClass().getResourceAsStream("simplePricelist.xlsx"));
    }

    private void testSimplePriceList(InputStream stream) {
        Iterator<FileRow> iterator = new PoiExcelFileIterator(stream);

        // First row
        assertTrue("hasNext() should return true", iterator.hasNext());
        FileRow row = iterator.next();
        assertNotNull("File contains exactly one row", row);
        assertFalse("Row shouldn't be empty", row.isEmpty());

        assertEquals("First cell should contain 'Manufacturer1' value", "Manufacturer1", row.getStringFieldValue(0));
        assertEquals("Second cell should contain 'Model' value", "Model", row.getStringFieldValue(1));
        assertEquals("Third cell should contain 'Feature' value", "Feature", row.getStringFieldValue(2));
        assertEquals("Fourth cell should contain '12345' string value", "12345", row.getStringFieldValue(3));
        assertEquals("Fifth cell should contain 'DetailName1' string value", "DetailName1", row.getStringFieldValue(4));
        assertEquals("Sixth cell should contain '8' integer value", (Integer) 8, row.getIntegerFieldValue(5));
        assertEquals("Seventh cell should contain '1' integer value", (Integer) 1, row.getIntegerFieldValue(6));
        assertEquals("Eights cell should contain '1234.34' double value", (Double) 1234.34, row.getDoubleFieldValue(7));

        //Second row
        assertTrue("hasNext() should return true", iterator.hasNext());
        row = iterator.next();
        assertNotNull("File contains exactly one row", row);
        assertFalse("Row shouldn't be empty", row.isEmpty());
        assertEquals("First cell should contain 'Manufacturer1' value", "Manufacturer2", row.getStringFieldValue(0));
        assertTrue("Second cell should have null value", row.isFieldEmpty(1));
        assertNull("Second cell should have null value", row.getStringFieldValue(1));
        assertEquals("Third cell should contain 'Feature' value", "Feature", row.getStringFieldValue(2));
        assertEquals("Fourth cell should contain 'NMB12345' string value", "NMB12345", row.getStringFieldValue(3));
        assertEquals("Fifth cell should contain 'DetailName1' string value", "DetailName2", row.getStringFieldValue(4));
        assertEquals("Sixth cell should contain '40' integer value", (Integer) 40, row.getIntegerFieldValue(5));
        assertTrue("Seventh cell should have null value", row.isFieldEmpty(6));
        assertNull("Seventh cell should have null value", row.getIntegerFieldValue(6));
        assertEquals("Eights cell should contain '34.5' double value", (Double) 34.5, row.getDoubleFieldValue(7));


        assertFalse("hasNext() should return false as file contains only two rows", iterator.hasNext());
    }

    private void testSimpleRow(InputStream stream) {
        Iterator<FileRow> iterator = new PoiExcelFileIterator(stream);
        assertTrue("hasNext() should return true", iterator.hasNext());
        FileRow row = iterator.next();
        assertNotNull("File contains exactly one row", row);
        assertFalse("Row shouldn't be empty", row.isEmpty());
        assertEquals("First cell should contain 'first' value", "first", row.getStringFieldValue(0));
        assertEquals("Second cell should contain 'second' value", "second", row.getStringFieldValue(1));
        assertTrue("Third cell should be empty", row.isFieldEmpty(2));
        assertNull("Third cell should have null velue", row.getStringFieldValue(2));
        assertEquals("Fourth cell should contain 'third' value", "third", row.getStringFieldValue(3));
        assertEquals("Fifth cell should contain 'four' value", "four", row.getStringFieldValue(4));
    }
}
