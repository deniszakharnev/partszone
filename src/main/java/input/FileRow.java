package input;

public interface FileRow {

    boolean isEmpty();

    boolean isFieldEmpty(int index);

    String getStringFieldValue(int index);
    
    Integer getIntegerFieldValue(int index);

    Double getDoubleFieldValue(int index);
}
