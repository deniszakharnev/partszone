package domain;

import com.google.common.base.Objects;

public class DetailNumber {
    private Integer id;
    private Manufacturer manufacturer;
    private String value;
    private String detailName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("manufacturer", manufacturer)
                .add("value", value)
                .add("detailName", detailName)
                .toString();
    }
}
