package TestProject.service.utils;

public class LogServiceMessageUtil {
    private static final String FAIL = "FAIL in ";
    private static final String SUCCESS = "SUCCESS in ";
    private static final String METHOD_NAME = "METHOD: ";

    public static String getFailDebugMessage(String methodName, String daoName) {
        StringBuilder sb = new StringBuilder();
        sb.append(FAIL).append(daoName).append(".");
        sb.append(METHOD_NAME).append(methodName).append(".");
        return sb.toString();
    }

    public static String getSuccessInfoMessage(String methodName, String daoName) {
        StringBuilder sb = new StringBuilder();
        sb.append(SUCCESS).append(daoName).append(". ");
        sb.append(METHOD_NAME).append(methodName).append(".");
        return sb.toString();
    }
}
