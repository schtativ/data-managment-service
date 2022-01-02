package schtativ.datamanagementservice.common.sql.entity;

import lombok.Getter;
import schtativ.datamanagementservice.common.sql.entity.type.DataTypeInfo;

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
     * Information about type of value
     */
    protected DataTypeInfo dataTypeInfo;

    /**
     * Can value be null
     */
    protected Boolean isNullable;

    /**
     * Init required fields data
     *
     * @param name                   Name of column
     * @param dataTypeInfo               Data type of column
     * @param isNullable             Value may be null
     * @return Initialized column
     */
    public Column(String name, DataTypeInfo dataTypeInfo, Boolean isNullable) {
        this.name = name;
        this.dataTypeInfo = dataTypeInfo;
        this.isNullable = isNullable;
    }

}
