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
    String get(DataType dataType);
}
