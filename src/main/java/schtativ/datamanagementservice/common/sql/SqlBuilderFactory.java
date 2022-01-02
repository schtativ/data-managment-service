package schtativ.datamanagementservice.common.sql;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.CommonHelper;
import schtativ.datamanagementservice.common.sql.convert.SqlConverter;

@Component
public class SqlBuilderFactory {

    private final SqlConverter sqlConverter;

    public SqlBuilderFactory(ApplicationContext context, @Qualifier("dbmsName") String dbmsName) {
        this.sqlConverter = CommonHelper.getNeccessaryBean(context, dbmsName, SqlConverter.class);
    }

    public SqlBuilder get() {
        return new SqlBuilder(sqlConverter);
    }
}
