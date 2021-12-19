package schtativ.datamanagementservice.common;

public class StringHelper {
    public static boolean notEmpty(String value) {
        return value != null && !value.equals("");
    }
}
