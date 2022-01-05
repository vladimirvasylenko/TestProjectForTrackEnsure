package TestProject.dao.utils;

public class LogDaoMessageUtil {
    private static final String FAIL = "FAIL in ";
    private static final String SUCCESS = "SUCCESS in ";
    private static final String FIND_ALL = "Find All ";
    private static final String SAVE = "Save ";
    private static final String TABLE = "Table: ";


    public static String getFailFindDebugMessage(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(FAIL).append(FIND_ALL);
        sb.append(TABLE).append(tableName).append(".");
        return sb.toString();
    }

    public static String getSuccessFindInfoMessage(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(SUCCESS).append(FIND_ALL);
        sb.append(TABLE).append(tableName).append(".");
        return sb.toString();
    }

    public static String getFailSaveDebugMessage(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(FAIL).append(SAVE);
        sb.append(TABLE).append(tableName).append(".");
        return sb.toString();
    }

    public static String getSuccessSaveInfoMessage(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append(SUCCESS).append(SAVE);
        sb.append(TABLE).append(tableName).append(".");
        return sb.toString();
    }

}
