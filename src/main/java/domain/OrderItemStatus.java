package domain;

public enum OrderItemStatus {
    IN_CART(1),
    ACCEPTED(2),
    REQUESTED(3),
    WRITE_OUT(4),
    SENT(5),
    REDEEMED(6),
    ON_STOCK(7),
    ON_POINT(8),
    GIVEN_OUT(9),
    REFUSED_BY_MANAGER(10),
    REFUSED_BY_LOGIST(11),
    REMOVED(12),
    REFUSED_BY_CUSTOMER(13),
    INCOMING(14),
    REORDERED(17);

    private Integer statusId;

    OrderItemStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public static OrderItemStatus findByStatusId(Integer statusId) {
        for (OrderItemStatus status : values()) {
            if (status.statusId.equals(statusId)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Can't find order item status with id=" + statusId);
    }
}
