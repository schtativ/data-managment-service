package schtativ.datamanagementservice.common.sql.convert;

import schtativ.datamanagementservice.common.DbmsComponent;
import schtativ.datamanagementservice.common.DbmsName;
import schtativ.datamanagementservice.common.sql.entity.type.DataType;

import java.util.Hashtable;
import java.util.Map;

/**
 * Data type converter for PostgreSQL
 */
@DbmsComponent(name = DbmsName.POSTGRESQL)
public class PostgreDataTypeConverter implements DataTypeConverter {

    private final Map<DataType, String> types;

    /**
     * Ctor
     */
    public PostgreDataTypeConverter() {
        types = new Hashtable<>();
        types.put(DataType.BOOLEAN, "boolean");
        types.put(DataType.DATETIME, "timestamp");
        types.put(DataType.DECIMAL, "numeric");
        types.put(DataType.INT, "int4");
        types.put(DataType.LONG, "int8");
        types.put(DataType.SHORT, "int2");
        types.put(DataType.STRING, "varchar");
    }

    /**
     * Gets postgresql type
     *
     * @param dataType System data type
     */
    @Override
    public String getDbmsTypeName(DataType dataType) {
        return types.get(dataType);
    }

    /**
     * Gets system type from postgresql type
     *
     * @param dbmsTypeNane Postgresql type
     */
    @Override
    public DataType getSystemDataType(String dbmsTypeNane) {
        for (Map.Entry<DataType, String> entry :
                types.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(dbmsTypeNane)) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("DataType " + dbmsTypeNane + " is not founded.");
    }
}
