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

    public DataStorageRepositoryFactory(@Qualifier("dbmsName") String dbmsName, ApplicationContext context) {
        this.dbmsName = dbmsName;

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

    public DataStorageRepository get() {
        return dataStorageRepository;
    }
}
