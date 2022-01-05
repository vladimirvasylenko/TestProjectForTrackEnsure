package TestProject.service;

import TestProject.dao.ClientDao;
import TestProject.dto.ClientDto;
import TestProject.entities.Client;
import TestProject.entities.Messages;
import TestProject.service.utils.LogServiceMessageUtil;
import org.apache.log4j.Logger;

public class ClientService {

    private static final Logger LOG = Logger.getLogger(Messages.class.getName());
    private static final String SAVE_METHOD_NAME = "save()";
    private static final String DAO = ClientDao.class.getName();

    private final ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public void save(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());

        clientDao.save(client);

        if (client == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(SAVE_METHOD_NAME, DAO));
        }
        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(SAVE_METHOD_NAME, DAO));
    }
}
