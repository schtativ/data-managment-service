package schtativ.datamanagementservice.common.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import schtativ.datamanagementservice.common.sql.entity.type.DataType;

@Getter
@AllArgsConstructor
public class PrimaryKey {

    /**
     * The table
     */
    private TableName table;

    /**
     * Type of primary key
     */
    private DataType type;
}
