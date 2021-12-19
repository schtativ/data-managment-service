package schtativ.datamanagementservice.dal.db.repository.base;

import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.dal.db.entity.base.ColumnInfo;

import java.util.Collection;
import java.util.List;

/**
 * Interaction with database system information
 */
public interface DataStorageRepository {
    /**
     * Gets information about columns of table
     * @param tableName Table name (schema is ignored)
     * @return Collection of column information
     */
    List<Column> getTableInfo(String tableName);

    /**
     * Creates table in data base in schema "data"
     * @param tableName Table name
     * @param columns Set of columns
     */
    void createTable(String tableName, Collection<Column> columns);
}
