package domain;

public enum UserType {

    ADMINISTRATOR(4),

    MANAGER(2),

    LOGIST(3);

    private Integer typeId;

    UserType(int type) {
        this.typeId = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public static UserType findById(Integer typeId) {
        for (UserType type : values()) {
            if (type.typeId.equals(typeId)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Can't find user type with id=" + typeId);
    }
}
