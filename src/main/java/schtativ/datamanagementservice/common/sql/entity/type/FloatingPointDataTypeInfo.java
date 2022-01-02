package schtativ.datamanagementservice.common.sql.entity.type;

import lombok.Getter;

@Getter
public class FloatingPointDataTypeInfo extends DataTypeInfo {

    /**
     * Maximum count of decimal places
     */
    private final Integer signMaxCount;

    /**
     * Maximum count of decimal places to the right of the decimal point
     */
    private final Integer signScaleCount;

    public FloatingPointDataTypeInfo(DataType type, Integer signMaxCount, Integer signScaleCount) {
        super(type);
        this.signMaxCount = signMaxCount;
        this.signScaleCount = signScaleCount;
    }
}
