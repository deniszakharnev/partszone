package input;

import static com.google.common.base.Strings.isNullOrEmpty;

public class PriceListUploadRow extends UploadRow implements Cloneable {
    private String model;
    private String feature;
    private String currency;
    private String quantity;
    private String minimalQuantity;
    private Double price;
    private String manufacturerName;
    private String detailNumber;
    private String detailName;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMinimalQuantity() {
        return minimalQuantity;
    }

    public Integer getIntMinimalQuantity() {
        if (minimalQuantity != null) {
            return Integer.parseInt(minimalQuantity);
        }
        return null;
    }

    public void setMinimalQuantity(String minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }


    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getDetailNumber() {
        return detailNumber;
    }

    public void setDetailNumber(String detailNumber) {
        this.detailNumber = detailNumber;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    @Override
    public boolean isEmpty() {
        return isNullOrEmpty(manufacturerName)
                && isNullOrEmpty(feature)
                && isNullOrEmpty(detailNumber)
                && isNullOrEmpty(detailName)
                && isNullOrEmpty(quantity)
                && isNullOrEmpty(minimalQuantity)
                && price == 0.0;
    }


    @Override
    public PriceListUploadRow clone() throws CloneNotSupportedException {
        PriceListUploadRow copyRow = new PriceListUploadRow();

        copyRow.setManufacturerName(getManufacturerName());
        copyRow.setDetailNumber(getDetailNumber());
        copyRow.setDetailName(getDetailName());
        copyRow.setModel(model);
        copyRow.setFeature(feature);
        copyRow.setPrice(price);
        copyRow.setQuantity(quantity);
        copyRow.setMinimalQuantity(minimalQuantity);
        copyRow.setCurrency(currency);

        return copyRow;
    }
}
