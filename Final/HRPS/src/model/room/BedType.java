package model.room;

public enum BedType {
    SINGLE("Single"),
    DOUBLE("Double"),
    MASTER("Master");

	/**
     * The type of this bed.
     */
    private String type;

    /**
     * Create a new bed type.
     * @param type This BedType's type.
     */
    BedType(String type) {
        this.type = type;
    }

    /**
     * Get the type of this BedType.
     * @return this BedType type.
     */
    public String getType() {
        return type;
    }
}
