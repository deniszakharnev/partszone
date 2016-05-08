package domain;

import com.google.common.base.Objects;

import java.math.BigDecimal;

public class StockEntry {
    private Integer id;
    private DetailNumber detailNumber;
    private Dealer dealer;
    private String pricelistNumber;
    private String pricelistDetailName;
    private BigDecimal price;
    private Integer availableQuantity;
    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DetailNumber getDetailNumber() {
        return detailNumber;
    }

    public void setDetailNumber(DetailNumber detailNumber) {
        this.detailNumber = detailNumber;
    }

    public String getPricelistNumber() {
        return pricelistNumber;
    }

    public void setPricelistNumber(String pricelistNumber) {
        this.pricelistNumber = pricelistNumber;
    }

    public String getPricelistDetailName() {
        return pricelistDetailName;
    }

    public void setPricelistDetailName(String pricelistDetailName) {
        this.pricelistDetailName = pricelistDetailName;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("detailNumber", detailNumber)
                .add("dealer", dealer)
                .add("pricelistNumber", pricelistNumber)
                .add("pricelistDetailName", pricelistDetailName)
                .add("price", price)
                .add("availableQuantity", availableQuantity)
                .add("active", active)
                .toString();
    }
}
