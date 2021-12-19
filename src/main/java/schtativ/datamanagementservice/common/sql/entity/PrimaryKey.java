package schtativ.datamanagementservice.common.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
