package schtativ.datamanagementservice.common.sql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableName {
    /**
     * Table schema
     */
    private String schema;

    /**
     * Table name
     */
    private String name;

}
