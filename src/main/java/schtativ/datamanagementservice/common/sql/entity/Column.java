package schtativ.datamanagementservice.common.sql.entity;

import lombok.Getter;

/**
 * Information about column
 */
@Getter
public class Column {
    /**
     * Name of the column
     */
    protected String name;

    /**
     * Type of value
     */
    protected DataType dataType;

    /**
     * Maximum length for a string value
     */
    protected Integer characterMaximumLength;

    /**
     * Can value be null
     */
    protected Boolean isNullable;

    /**
     * Init required fields data
     *
     * @param name                   Name of column
     * @param dataType               Data type of column
     * @param characterMaximumLength Maximum length when char datatype
     * @param isNullable             Value may be null
     * @return Initialized column
     */
    public Column(String name, DataType dataType, Integer characterMaximumLength, Boolean isNullable) {
        this.name = name;
        this.dataType = dataType;
        this.characterMaximumLength = characterMaximumLength;
        this.isNullable = isNullable;
    }

}
