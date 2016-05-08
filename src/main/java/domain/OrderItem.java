package domain;

import com.google.common.base.Objects;

import java.math.BigDecimal;

public class OrderItem {
    private Integer id;
    private Order order;
    private String detailNumber;
    private String detailName;
    private Integer quantity;
    private BigDecimal price;
    private OrderItemStatus status;
    private String feature;
    private String externalId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderItemStatus getStatus() {
        return status;
    }

    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("order", order)
                .add("detailNumber", detailNumber)
                .add("detailName", detailName)
                .add("quantity", quantity)
                .add("price", price)
                .add("status", status)
                .add("feature", feature)
                .add("externalId", externalId)
                .toString();
    }
}
