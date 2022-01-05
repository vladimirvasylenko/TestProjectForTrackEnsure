package TestProject.controller.utils;

public class LogControllerMessageUtil {
    private static final String SERVLET_ERROR = "SERVLET ERROR";
    private static final String IO_EXCEPTION = "IO EXCEPTION";
    private static final String IN = "IN";

    private static final String DOT = ".";
    private static final String SPACE = " ";

    public static String getServletErrorMessage(String servletName) {
        StringBuilder sb = new StringBuilder();
        sb.append(SERVLET_ERROR).append(SPACE).append(IN).append(SPACE).append(servletName).append(DOT);
        return sb.toString();
    }

    public static String getIOExceptionMessage(String servletName) {
        StringBuilder sb = new StringBuilder();
        sb.append(IO_EXCEPTION).append(SPACE).append(IN).append(SPACE).append(servletName).append(DOT);
        return sb.toString();
    }
}
