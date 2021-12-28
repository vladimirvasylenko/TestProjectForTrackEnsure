package TestProject.service;

import TestProject.dao.ClientDao;
import TestProject.dto.ClientDto;
import TestProject.entities.Client;

public class ClientService {

    private final ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public void save(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());

        clientDao.save(client);
    }

}
