package schtativ.datamanagementservice.dal.db.mapper;

import org.springframework.jdbc.core.RowMapper;
import schtativ.datamanagementservice.common.sql.entity.Column;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColumnMapper implements RowMapper<Column> {

    @Override
    public Column mapRow(ResultSet rs, int rowNum) throws SQLException {
        String columnName = rs.getString("column_name");
        String dataType = rs.getString("data_type");
        String characterMaximumLength = rs.getString("character_maximum_length");
        String columnDefault = rs.getString("column_default");
        String isNullable = rs.getString("is_nullable");

        return null;
    }
}
