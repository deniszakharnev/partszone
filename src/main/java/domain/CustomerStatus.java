package domain;

public enum CustomerStatus {
    ACTIVE(1),
    DISABLED(0);

    private Integer statusId;

    CustomerStatus(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }

    public static CustomerStatus findById(Integer statusId) {
        for (CustomerStatus status : values()) {
            if (status.statusId.equals(statusId)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Can't find customer status with id=" + statusId);
    }
}
