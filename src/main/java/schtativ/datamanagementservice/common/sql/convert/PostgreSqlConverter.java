package schtativ.datamanagementservice.common.sql.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.DbmsComponent;
import schtativ.datamanagementservice.common.DbmsName;
import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.common.sql.entity.ForeignKey;
import schtativ.datamanagementservice.common.sql.entity.PrimaryKey;
import schtativ.datamanagementservice.common.sql.entity.TableName;
import schtativ.datamanagementservice.common.sql.entity.type.CharDataTypeInfo;
import schtativ.datamanagementservice.common.sql.entity.type.DataTypeInfo;
import schtativ.datamanagementservice.common.sql.entity.type.FloatingPointDataTypeInfo;

@Component
@DbmsComponent(name = DbmsName.POSTGRESQL)
public class PostgreSqlConverter implements SqlConverter {

    private final DataTypeConverter dataTypeConverter;

    @Autowired
    public PostgreSqlConverter(DataTypeConverter dataTypeConverter) {
        this.dataTypeConverter = dataTypeConverter;
    }

    @Override
    public String toSql(Column column) {
        StringBuilder builder = new StringBuilder();
        builder.append(column.getName());
        builder.append(" ");
        builder.append(toSql(column.getDataTypeInfo(), column.getDataTypeInfo().getClass()));

        if (!column.getIsNullable()) {
            builder.append(" not");
        }

        builder.append(" null");
        return builder.toString();
    }

    @Override
    public String toSql(TableName tableName) {
        return String.format("%s.%s", tableName.getSchema(), tableName.getName());
    }

    @Override
    public String toSql(ForeignKey foreignKey) {
        StringBuilder builder = new StringBuilder();
        builder.append("CONSTRAINT ");
        builder.append(String.format("fk_%s_%s_%s_%s ", foreignKey.getTable().getName(), foreignKey.getColumnName(), foreignKey.getReferenceByTable().getName(), foreignKey.getColumnName()));
        builder.append(String.format("FOREIGN KEY(%s) ", foreignKey.getColumnName()));
        builder.append(String.format("REFERENCES %s.%s(%s)", foreignKey.getReferenceByTable().getSchema(), foreignKey.getReferenceByTable().getName(), foreignKey.getReferenceByColumnName()));

        return builder.toString();
    }

    @Override
    public String toSql(PrimaryKey primaryKey) {
        return String.format("id %s generated by default as identity constraint %s_%s_pkey primary key",
                dataTypeConverter.get(primaryKey.getType()),
                primaryKey.getTable().getSchema(),
                primaryKey.getTable().getName());
    }

    @Override
    public <T extends DataTypeInfo> String toSql(DataTypeInfo dataTypeInfo, Class<T> clazz) {
        StringBuilder builder = new StringBuilder();
        builder.append(dataTypeConverter.get(dataTypeInfo.getType()));
        if (clazz.equals(CharDataTypeInfo.class)) {
            builder.append(String.format("(%d)", ((CharDataTypeInfo) dataTypeInfo).getCharacterMaximumLength()));
        }

        if (clazz.equals(FloatingPointDataTypeInfo.class)) {
            FloatingPointDataTypeInfo floatingPointInfo = (FloatingPointDataTypeInfo) dataTypeInfo;
            builder.append(String.format("(%d,%d)", floatingPointInfo.getSignMaxCount(), floatingPointInfo.getSignScaleCount()));
        }

        return builder.toString();
    }
}
