package schtativ.datamanagementservice.dal.db.repository.base;

import schtativ.datamanagementservice.common.DbmsName;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for repositories that access to interact with DBMS
 * (read structure of tables, create tables, etc.)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DbmsRepository {
    /**
     * Name of database management system.
     * @return
     */
    DbmsName name();
}
