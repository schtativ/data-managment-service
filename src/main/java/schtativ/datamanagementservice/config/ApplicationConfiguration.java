package schtativ.datamanagementservice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class ApplicationConfiguration {

    @Bean
    String DbmsName(DataSource dataSource) {
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
}
