package schtativ.datamanagementservice.dal.db.repository.base;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.CommonHelper;

import javax.sql.DataSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory that produce data storage repository by data storage system name
 */
@Component
public class DataStorageRepositoryFactory {

    private final DataStorageRepository dataStorageRepository;
    private final String dbmsName;

    public DataStorageRepositoryFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext context) {
        dbmsName = getDbmsName(dataSource);

        dataStorageRepository = getNeccessaryDataStorageRepository(context, dbmsName);
        if (dataStorageRepository == null) {
            throw new IllegalArgumentException("DBMS Repository is not finded by name.");
        }
    }

    /**
     * Gets data storage repository from application context by annotation DbmsRepository and DBMS name
     *
     * @param context  Application context for bean getting
     * @param dbmsName DBMS name
     * @return Data Storage Repository or null
     */
    private DataStorageRepository getNeccessaryDataStorageRepository(ApplicationContext context, String dbmsName) {
        return CommonHelper.getNeccessaryBean(context, dbmsName, DataStorageRepository.class);
    }

    /**
     * Get DBMS name, extracted from connection string
     *
     * @param dataSource Data Source
     * @return DBMS name
     */
    private String getDbmsName(DataSource dataSource) {
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

    public DataStorageRepository get() {
        return dataStorageRepository;
    }
}
