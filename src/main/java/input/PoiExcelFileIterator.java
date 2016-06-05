package input;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.InputStream;
import java.util.Iterator;

public class PoiExcelFileIterator implements Iterator<FileRow> {

    private Workbook workbook;

    private int currentSheetIdx;
    private int currentRowIdx;

    public PoiExcelFileIterator(InputStream stream) {
        currentSheetIdx = 0;
        currentRowIdx = 1;
        try {
            workbook = WorkbookFactory.create(stream);
        } catch (Exception e) {
            throw new IllegalArgumentException("Bad input stream", e);
        }
    }

    @Override
    public boolean hasNext() {
        return !(isLastSheet() && isNoMoreRowsOnTheSheet());
    }

    @Override
    public FileRow next() {
        PoiExcelFileRow excelRow = new PoiExcelFileRow(workbook.getSheetAt(currentSheetIdx).getRow(currentRowIdx));
        currentRowIdx++;
        if (!isLastSheet() && isNoMoreRowsOnTheSheet()) {
            currentSheetIdx++;
            currentRowIdx = 1;
        }
        return excelRow;
    }

    @Override
    public void remove() {
        throw new RuntimeException("method is not implemented");
    }

    private boolean isLastSheet() {
        return currentSheetIdx >= workbook.getNumberOfSheets() - 1;
    }

    private boolean isNoMoreRowsOnTheSheet() {
        return currentRowIdx > workbook.getSheetAt(currentSheetIdx).getLastRowNum();
    }
}
