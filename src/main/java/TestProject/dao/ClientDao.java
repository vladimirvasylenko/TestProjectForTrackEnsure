package TestProject.dao;

import TestProject.dao.utils.LogDaoMessageUtil;
import TestProject.database.Database;
import TestProject.dto.ClientDto;
import TestProject.entities.Client;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private static final Logger log = Logger.getLogger(ClientDao.class);

    private static final String INSERT = "INSERT INTO clients (name) VALUES (?)";
    private static final String CLIENTS_ID = "SELECT * FROM clients ORDER BY id DESC LIMIT 1";
    private static final Logger LOG = Logger.getLogger(ClientDao.class.getName());
    private static final String TABLE_NAME = "CLIENTS";

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
            LOG.info(LogDaoMessageUtil.getSuccessFindInfoMessage(TABLE_NAME));
        } catch (SQLException | IOException exception) {
            LOG.debug(LogDaoMessageUtil.getFailFindDebugMessage(TABLE_NAME));
        }

        return resultList;
    }

    public void save(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, client.getName());
            statement.execute();

            LOG.info(LogDaoMessageUtil.getSuccessSaveInfoMessage(TABLE_NAME));
        } catch (SQLException | IOException exception) {
            LOG.debug(LogDaoMessageUtil.getFailSaveDebugMessage(TABLE_NAME));
        }
    }
}
