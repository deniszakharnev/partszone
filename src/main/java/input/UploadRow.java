package input;

import domain.FileUpload;

import java.util.Arrays;

public abstract class UploadRow {
    public static final String FILEROW_DELIMITER = "|";
    private static final String FILEROW_DELIMITER_REGEXP = "\\|";

    private Integer id;

    private String fileRow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileRow() {
        return fileRow;
    }

    public void setFileRow(String fileRow) {
        this.fileRow = fileRow;
    }

    public Iterable<String> getFileRowFields() {
        return fileRow != null ? Arrays.asList(fileRow
                .split(FILEROW_DELIMITER_REGEXP)) : null;
    }

    public abstract boolean isEmpty();
}
