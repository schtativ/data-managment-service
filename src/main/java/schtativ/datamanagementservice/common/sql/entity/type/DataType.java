package schtativ.datamanagementservice.common.sql.entity.type;

/**
 * Type of data
 */
public enum DataType {
    /**
     * 2 bytes numeric type
     */
    SHORT(true),

    /**
     * 4 bytes numeric type
     */
    INT(true),

    /**
     * 8 bytes numeric type
     */
    LONG(true),

    /**
     * Numeric with fixed comma type
     */
    DECIMAL(false),

    /**
     * Varchar type
     */
    STRING(false),

    /**
     * Logical type
     */
    BOOLEAN(false),

    /**
     * Date and time type
     */
    DATETIME(false),

    /**
     * Universally unique identifier type
     */
    UUID(false);

    /**
     * Can be used for primary key type
     */
    private boolean forPrimaryKey;

    /**
     * Ctr
     * @param forPrimaryKey Can be used for primary key type
     */
    DataType(boolean forPrimaryKey) {
        this.forPrimaryKey = forPrimaryKey;
    }
}
