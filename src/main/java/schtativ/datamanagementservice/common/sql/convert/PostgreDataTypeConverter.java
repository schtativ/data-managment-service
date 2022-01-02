package schtativ.datamanagementservice.common.sql.convert;

import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.DbmsName;
import schtativ.datamanagementservice.common.sql.entity.type.DataType;
import schtativ.datamanagementservice.common.DbmsComponent;

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
        types.put(DataType.INT, "integer");
        types.put(DataType.LONG, "bigint");
        types.put(DataType.SHORT, "smallint");
        types.put(DataType.STRING, "varchar");
    }

    /**
     * Get postgresql type
     * @param dataType System data type
     */
    @Override
    public String get(DataType dataType) {
        return types.get(dataType);
    }
}
