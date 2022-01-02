package schtativ.datamanagementservice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import schtativ.datamanagementservice.common.CommonHelper;
import schtativ.datamanagementservice.common.sql.convert.DataTypeConverter;

import javax.sql.DataSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class ApplicationConfiguration {

    @Bean
    String dbmsName(DataSource dataSource) {
        if (!(dataSource instanceof HikariDataSource)) {
            throw new IllegalArgumentException("Type of DataSource is unexpected.");
        }
        String jdbcUrl = ((HikariDataSource) dataSource).getJdbcUrl();
        Pattern pattern = Pattern.compile("jdbc:(.*?):.*");
        Matcher matcher = pattern.matcher(jdbcUrl);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException("Name of DBMS is not defined.");
        }
    }

    @Bean
    DataTypeConverter dataTypeConverter(ApplicationContext context, @Qualifier("dbmsName") String dbmsName) {
        return CommonHelper.getNeccessaryBean(context, dbmsName, DataTypeConverter.class);
    }
}
