package schtativ.datamanagementservice.common;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for repositories that access to interact with DBMS
 * (read structure of tables, create tables, etc.)
 */
@Component
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DbmsComponent {
    /**
     * Name of database management system.
     *
     * @return
     */
    DbmsName name();
}
