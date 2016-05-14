package input;

import domain.FileUpload;

import java.util.Arrays;

public abstract class UploadRow {
    public static final String FILEROW_DELIMITER = "|";
    private static final String FILEROW_DELIMITER_REGEXP = "\\|";

    private Integer id;

    private String fileRow;

    private FileUpload upload;

    public UploadRow(FileUpload upload) {
        this.upload = upload;
    }

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

    public FileUpload getUpload() {
        return upload;
    }

    public void setUpload(FileUpload upload) {
        this.upload = upload;
    }
}
