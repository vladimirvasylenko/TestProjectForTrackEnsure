package TestProject.database;

import TestProject.database.utils.LogDatabaseMessageUtil;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    static String FILE_PATH = "C:\\Users\\vasyl\\IdeaProjects\\TestProjectForTrackEnsure" +
                                   "\\src\\main\\resources\\application.properties";
    private static final Logger LOG = Logger.getLogger(Database.class.getName());

    public static Connection getConnection() throws IOException {

        Properties props = new Properties();
        props.load(new FileInputStream(FILE_PATH));

        String DRIVER = props.getProperty("jdbc.driver");

        String URL = props.getProperty("jdbc.url");

        String USERNAME = props.getProperty("jdbc.username");

        String PASSWORD = props.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
//            LOG.info(LogDatabaseMessageUtil.getSuccessInfoMessage());
            LOG.info("Database is connected");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error(LogDatabaseMessageUtil.getErrorMessage());
        }
        return null;
    }
}


