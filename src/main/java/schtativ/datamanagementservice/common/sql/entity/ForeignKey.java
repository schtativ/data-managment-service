package schtativ.datamanagementservice.common.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Information about foreign key for column
 */
@Getter
@Setter
@AllArgsConstructor
public class ForeignKey {

    /**
     * The dependent table
     */
    private TableName table;

    /**
     * The dependent column
     */
    private String columnName;

    /**
     * The table that is referenced by key
     */
    private TableName referenceByTable;

    /**
     * The column that is referenced by key
     */
    private String referenceByColumnName;
}
