package domain;

import com.google.common.base.Objects;

public class Customer {
    private Integer id;
    private UserType type;
    private CustomerStatus status;
    private String name;
    private String email;
    private String contactPhone;
    private Integer discount;
    private Boolean wholesale;
    private Boolean vip;
    private Boolean onlineShopStock;
    private Boolean realStock;
    private Boolean orderingNotPermitted;
    private Boolean useDealerPrice;
    private String externalId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getWholesale() {
        return wholesale;
    }

    public void setWholesale(Boolean wholesale) {
        this.wholesale = wholesale;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Boolean getOnlineShopStock() {
        return onlineShopStock;
    }

    public void setOnlineShopStock(Boolean onlineShopStock) {
        this.onlineShopStock = onlineShopStock;
    }

    public Boolean getRealStock() {
        return realStock;
    }

    public void setRealStock(Boolean realStock) {
        this.realStock = realStock;
    }

    public Boolean getOrderingNotPermitted() {
        return orderingNotPermitted;
    }

    public void setOrderingNotPermitted(Boolean orderingNotPermitted) {
        this.orderingNotPermitted = orderingNotPermitted;
    }

    public Boolean getUseDealerPrice() {
        return useDealerPrice;
    }

    public void setUseDealerPrice(Boolean useDealerPrice) {
        this.useDealerPrice = useDealerPrice;
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
                .add("type", type)
                .add("status", status)
                .add("name", name)
                .add("email", email)
                .add("contactPhone", contactPhone)
                .add("discount", discount)
                .add("wholesale", wholesale)
                .add("vip", vip)
                .add("onlineShopStock", onlineShopStock)
                .add("realStock", realStock)
                .add("orderingNotPermitted", orderingNotPermitted)
                .add("useDealerPrice", useDealerPrice)
                .add("externalId", externalId)
                .toString();
    }
}
