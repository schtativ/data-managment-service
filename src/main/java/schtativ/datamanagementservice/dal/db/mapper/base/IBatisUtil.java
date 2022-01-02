package schtativ.datamanagementservice.dal.db.mapper.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.sql.SqlBuilderFactory;
import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.common.sql.entity.type.DataType;

import java.util.Collection;

@Component
public class IBatisUtil {

    @Autowired
    private SqlBuilderFactory sqlBuilderFactory;

    public String createTable(String tableName, Collection<Column> columns) {
        String sql = sqlBuilderFactory.get()
                .createTable("data", tableName)
                .primaryKey(DataType.INT)
                .columns(columns)
                .build();

        return sql;
    }
}
