package input;

import java.math.BigDecimal;

public interface PricelistRow {
    String getManufacturerName();
    String getDetailNumber();
    String getDetailName();
    String getFeature();
    Integer getQuantity();
    Integer getMinQuantity();
    BigDecimal getPrice();
    String getModel();
}
