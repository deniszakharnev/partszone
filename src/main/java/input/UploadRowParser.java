package input;

public interface UploadRowParser<K extends UploadRow> {
    K parse(FileRow row) throws ParseRowException;
}
