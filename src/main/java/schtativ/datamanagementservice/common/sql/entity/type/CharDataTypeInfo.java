package schtativ.datamanagementservice.common.sql.entity.type;

import lombok.Getter;

@Getter
public class CharDataTypeInfo extends DataTypeInfo {

    /**
     * Maximum length of string
     */
    private final Integer characterMaximumLength;

    public CharDataTypeInfo(DataType type, Integer characterMaximumLength) {
        super(type);
        this.characterMaximumLength = characterMaximumLength;
    }
}
