package schtativ.datamanagementservice.dal.db.repository.base;

import schtativ.datamanagementservice.dal.db.entity.base.ColumnInfo;

import java.util.List;

/**
 * Interaction with database system information
 */
public interface DataStorageRepository {
    /**
     * Get information about columns of table
     * @param tableName Table name (schema is ignored)
     * @return Collection of column information
     */
    List<ColumnInfo> getTableInfo(String tableName);
}
