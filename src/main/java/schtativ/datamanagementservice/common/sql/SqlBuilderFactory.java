package schtativ.datamanagementservice.common.sql;

import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.sql.convert.SqlConverter;

@Component
public class SqlBuilderFactory {

    private final SqlConverter sqlConverter;

    public SqlBuilderFactory(SqlConverter sqlConverter) {
        this.sqlConverter = sqlConverter;
    }

    public SqlBuilder get() {
        return new SqlBuilder(sqlConverter);
    }
}
