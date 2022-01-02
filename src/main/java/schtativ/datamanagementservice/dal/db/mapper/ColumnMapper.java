package schtativ.datamanagementservice.dal.db.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.sql.convert.DataTypeConverter;
import schtativ.datamanagementservice.common.sql.convert.SqlConverter;
import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.common.sql.entity.type.CharDataTypeInfo;
import schtativ.datamanagementservice.common.sql.entity.type.DataType;
import schtativ.datamanagementservice.common.sql.entity.type.DataTypeInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ColumnMapper implements RowMapper<Column> {

    private final SqlConverter sqlConverter;
    private final DataTypeConverter dataTypeConverter;

    @Autowired
    public ColumnMapper(SqlConverter sqlConverter, DataTypeConverter dataTypeConverter) {
        this.sqlConverter = sqlConverter;
        this.dataTypeConverter = dataTypeConverter;
    }

    @Override
    public Column mapRow(ResultSet rs, int rowNum) throws SQLException {
        String columnName = rs.getString("column_name");
        String dbmsTypeNane = rs.getString("udt_name");
        String characterMaximumLength = rs.getString("character_maximum_length");
        String columnDefault = rs.getString("column_default");
        String isNullable = rs.getString("is_nullable");

        DataTypeInfo dataTypeInfo;
        DataType dataType = dataTypeConverter.getSystemDataType(dbmsTypeNane);
        if (dataType.equals(DataType.STRING)) {
            dataTypeInfo = new CharDataTypeInfo(dataType, characterMaximumLength != null ? Integer.valueOf(characterMaximumLength) : null);
        } else {
            dataTypeInfo = new DataTypeInfo(dataType);
        }

        Column column = new Column(columnName, dataTypeInfo, sqlConverter.booleanValueFromSql(isNullable));
        return column;
    }
}
