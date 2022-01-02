package schtativ.datamanagementservice.common.sql.convert;

import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.common.sql.entity.ForeignKey;
import schtativ.datamanagementservice.common.sql.entity.PrimaryKey;
import schtativ.datamanagementservice.common.sql.entity.TableName;
import schtativ.datamanagementservice.common.sql.entity.type.DataTypeInfo;

/**
 * Converts entities to sql parts of query
 */
public interface SqlConverter {
    /**
     * Converts column information to sql
     *
     * @param column Column
     * @return Sql text for query
     */
    String toSql(Column column);

    /**
     * Converts table name to sql
     *
     * @param tableName Table name
     * @return Sql text for query
     */
    String toSql(TableName tableName);

    /**
     * Converts foreign key information to sql
     *
     * @param foreignKey Foreign key
     * @return Sql text for query
     */
    String toSql(ForeignKey foreignKey);

    /**
     * Converts primary key information to sql
     *
     * @param primaryKey Foreign key
     * @return Sql text for query
     */
    String toSql(PrimaryKey primaryKey);

    <T extends DataTypeInfo> String toSql(DataTypeInfo dataTypeInfo, Class<T> clazz);

    /**
     * Return boolean value from specific value of DBMS (examples: Y/N for PostgreSql, 1/0 for MSSQL)
     * @param value Value from DBMS
     * @return Boolean value
     */
    Boolean booleanValueFromSql(String value);
}
