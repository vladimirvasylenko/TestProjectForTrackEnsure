package TestProject.dao;

import TestProject.database.Database;
import TestProject.dto.ClientDto;
import TestProject.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private static final String INSERT = "INSERT INTO clients (name) VALUES (?)";
    private static final String CLIENTS_ID = "SELECT * FROM clients ORDER BY id DESC LIMIT 1";

    public List<Client> findClientsId() {
        List<Client> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(CLIENTS_ID);

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));

                resultList.add(client);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return resultList;
    }

    public void save(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, client.getName());
            statement.execute();
            ClientDto clientDto = new ClientDto();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
