package input;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class PoiExcelFileRow implements FileRow {

    private Row row;

    private DataFormatter defaultFormat = new DataFormatter();

    public PoiExcelFileRow(Row row) {
        this.row = row;
    }

    @Override
    public boolean isEmpty() {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
                return false;
        }
        return true;
    }

    @Override
    public boolean isFieldEmpty(int index) {
        Cell cell = row.getCell(index);
        return cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK;
    }

    @Override
    public String getStringFieldValue(int index) {
        if (!isFieldEmpty(index)) {
            return getStringCellValue(row.getCell(index));
        }
        return null;
    }

    @Override
    public Integer getIntegerFieldValue(int index) {
        if (!isFieldEmpty(index)) {
            return getIntegerCellValue(row.getCell(index));
        }
        return null;
    }

    @Override
    public Double getDoubleFieldValue(int index) {
        if (!isFieldEmpty(index)) {
            return getDoubleCellValue(row.getCell(index));
        }
        return null;
    }

    private String getStringCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getRichStringCellValue().getString();
            case Cell.CELL_TYPE_NUMERIC:
                return defaultFormat.formatCellValue(cell);
        }

        throw new IllegalArgumentException("Can't convert cell value to string: row=" + row.getRowNum() + ", column=" + cell.getColumnIndex());
    }

    private Integer getIntegerCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return Integer.parseInt(cell.getRichStringCellValue().getString());
            case Cell.CELL_TYPE_NUMERIC:
                return (int) cell.getNumericCellValue();
        }

        throw new IllegalArgumentException("Can't convert cell value to integer: row=" + row.getRowNum() + ", column=" + cell.getColumnIndex());
    }

    private Double getDoubleCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return Double.parseDouble(cell.getRichStringCellValue().getString());
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        throw new IllegalArgumentException("Can't convert cell value to double: row=" + row.getRowNum() + ", column=" + cell.getColumnIndex());
    }
}
