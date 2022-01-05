package TestProject.database.utils;

public class LogDatabaseMessageUtil {
    private static final String ERROR = "ERROR occurred";
    private static final String SUCCESS = "SUCCESS";
    private static final String DATABASE = "DATABASE";
    private static final String CONNECTED = "CONNECTED";
    private static final String NOT = "NOT";
    private static final String TO = "TO";

    private static final String DOT = ".";
    private static final String SPACE = " ";

    public static String getErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(ERROR).append(DOT);
        sb.append(NOT).append(SPACE).append(CONNECTED)
                .append(SPACE).append(TO).append(SPACE)
                .append(DATABASE).append(DOT);
        return sb.toString();
    }

    public static String getSuccessInfoMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(SUCCESS).append(DOT);
        sb.append(CONNECTED).append(SPACE).append(TO)
                .append(SPACE).append(DATABASE).append(DOT);
        return sb.toString();
    }
}
