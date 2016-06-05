package input;


public interface RowProcessor<K extends UploadRow> {
    public void process(K row);
}
