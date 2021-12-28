package TestProject.dao;

import TestProject.database.Database;
import TestProject.entities.Messages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessagesDao {

    private static final String INSERT = "INSERT INTO messages (client_id, text) VALUES (?, ?)";
    private static final String MESSAGES =
            "SELECT * FROM messages INNER JOIN clients " +
                    "ON (messages.client_id = clients.id) ORDER BY (messages.id) DESC LIMIT 50";


    public List<Messages> findAllMessages() {
        List<Messages> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(MESSAGES);

            while (resultSet.next()) {
                Messages messages = new Messages();
                messages.setText(resultSet.getString("name"));
                messages.setText(resultSet.getString("text"));

                resultList.add(messages);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }

    public void save(Messages messages) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, messages.getClientId());
            statement.setString(2, messages.getText());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
