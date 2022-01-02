package schtativ.datamanagementservice.dal.db.repository.base;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import schtativ.datamanagementservice.common.CommonHelper;
import schtativ.datamanagementservice.common.DbmsName;

/**
 * Factory that produce data storage repository by data storage system name
 */
@Component
public class DataStorageRepositoryFactory {

    private final DataStorageRepository dataStorageRepository;

    public DataStorageRepositoryFactory(@Qualifier("dbmsName") DbmsName dbmsName, ApplicationContext context) {
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
    private DataStorageRepository getNeccessaryDataStorageRepository(ApplicationContext context, DbmsName dbmsName) {
        return CommonHelper.getNeccessaryBean(context, dbmsName, DataStorageRepository.class);
    }

    public DataStorageRepository get() {
        return dataStorageRepository;
    }
}
