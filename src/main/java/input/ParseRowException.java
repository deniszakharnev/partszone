package input;

public class ParseRowException extends Exception {

    private UploadRow uploadRow;

    public ParseRowException() {
	super();
    }
    
    public ParseRowException(UploadRow uploadRow) {
	this();
	this.uploadRow = uploadRow;
    }

    public ParseRowException(String arg0) {
	super(arg0);
    }
    
    public ParseRowException(String arg0, UploadRow uploadRow) {
	this(arg0);
	this.uploadRow = uploadRow;
    }

    public ParseRowException(String arg0, Throwable arg1) {
	super(arg0, arg1);
    }

    public ParseRowException(Throwable arg0) {
	super(arg0);
    }

    public UploadRow getUploadRow() {
        return uploadRow;
    }
}
