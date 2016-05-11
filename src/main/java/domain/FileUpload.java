package domain;

import java.util.Date;

public class FileUpload {
    private Integer id;
    private String name;
    private Date startProcessing;
    private Date endProcessing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartProcessing() {
        return startProcessing;
    }

    public void setStartProcessing(Date startProcessing) {
        this.startProcessing = startProcessing;
    }

    public Date getEndProcessing() {
        return endProcessing;
    }

    public void setEndProcessing(Date endProcessing) {
        this.endProcessing = endProcessing;
    }
}
