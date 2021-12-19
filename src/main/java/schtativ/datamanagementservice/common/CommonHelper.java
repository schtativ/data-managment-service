package schtativ.datamanagementservice.common;

import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class CommonHelper {
    /**
     * Gets bean from application context by annotation DbmsRepository and DBMS name
     *
     * @param context  Application context for bean getting
     * @param dbmsName DBMS name
     * @param clazz    Class of bean
     * @return Bean or null
     */
    public static <T> T getNeccessaryBean(ApplicationContext context, String dbmsName, Class<T> clazz) {
        AtomicReference<T> tempBean = new AtomicReference<>();
        Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(DbmsComponent.class);
        beansWithAnnotation.forEach((s, b) -> {
            if (clazz.isInstance(b)) {
                DbmsComponent annotation = AnnotationUtils.findAnnotation(b.getClass(), DbmsComponent.class);
                if (annotation != null) {
                    DbmsName name = annotation.name();
                    if (name.toString().equalsIgnoreCase(dbmsName)) {
                        tempBean.set(clazz.cast(b));
                    }
                }
            }
        });
        return tempBean.get();
    }
}
