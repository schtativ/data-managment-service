package schtativ.datamanagementservice.common.sql.convert;

import schtativ.datamanagementservice.common.sql.entity.type.DataType;

/**
 * Data type converter
 */
public interface DataTypeConverter {
    /**
     * Get data type name for necessary sql server
     * @param dataType System data type
     */
    String getDbmsTypeName(DataType dataType);

    /**
     * Get system type by value from DBMS
     *
     * @param dbmsTypeNane Type of DBMS
     */
    DataType getSystemDataType(String dbmsTypeNane);
}
