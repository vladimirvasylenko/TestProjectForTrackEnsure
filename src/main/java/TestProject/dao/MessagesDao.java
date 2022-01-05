package TestProject.dao;

import TestProject.dao.utils.LogDaoMessageUtil;
import TestProject.database.Database;
import TestProject.entities.Messages;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessagesDao {

    private static final String INSERT = "INSERT INTO messages (client_id, text) VALUES (?, ?)";
    private static final String MESSAGES =
            "SELECT * FROM messages INNER JOIN clients " +
                    "ON (messages.client_id = clients.id) ORDER BY (messages.id) LIMIT 50";
    private static final Logger LOG = Logger.getLogger(ClientDao.class.getName());
    private static final String TABLE_NAME = "CLIENTS_MESSAGES";


    public List<Messages> findAllMessages() {
        List<Messages> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(MESSAGES);

            while (resultSet.next()) {
                Messages messages = new Messages();
                messages.setClientName(resultSet.getString("name"));
                messages.setText(resultSet.getString("text"));

                resultList.add(messages);
            }
            LOG.info(LogDaoMessageUtil.getSuccessFindInfoMessage(TABLE_NAME));
        } catch (SQLException | IOException exception) {
            LOG.debug(LogDaoMessageUtil.getFailFindDebugMessage(TABLE_NAME));
        }
        return resultList;
    }

    public void save(Messages messages) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, messages.getClientId());
            statement.setString(2, messages.getText());
            statement.execute();

            LOG.info(LogDaoMessageUtil.getSuccessSaveInfoMessage(TABLE_NAME));
        } catch (SQLException | IOException exception) {
            LOG.debug(LogDaoMessageUtil.getFailSaveDebugMessage(TABLE_NAME));
        }
    }

}
