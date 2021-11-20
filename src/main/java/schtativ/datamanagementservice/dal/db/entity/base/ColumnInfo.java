package schtativ.datamanagementservice.dal.db.entity.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnInfo {
    private String columnName;
    private String dataType;
    private String characterMaximumLength;
    private String isNullable;
}
