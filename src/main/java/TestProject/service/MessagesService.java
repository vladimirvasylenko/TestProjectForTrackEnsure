package TestProject.service;

import TestProject.dao.MessagesDao;
import TestProject.dto.MessageDto;
import TestProject.entities.Messages;
import TestProject.service.utils.LogServiceMessageUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MessagesService {

    private static final Logger LOG = Logger.getLogger(Messages.class.getName());
    private static final String FIND_METHOD_NAME = "findAllMessages()";
    private static final String SAVE_METHOD_NAME = "save()";
    private static final String DAO = Messages.class.getName();

    private final MessagesDao messagesDao;

    public MessagesService() {
        messagesDao = new MessagesDao();
    }

    public List<MessageDto> findAllMessages() {
        List<Messages> message = messagesDao.findAllMessages();
        List<MessageDto> result = new ArrayList<>();

        for (Messages messages : message) {
            MessageDto dto = new MessageDto();
            dto.setClientName(messages.getClientName());
            dto.setText(messages.getText());
            result.add(dto);
        }
        if (result == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(FIND_METHOD_NAME, DAO));
        }
        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(FIND_METHOD_NAME, DAO));
        return result;
    }

    public void save(MessageDto messageDto) {
        Messages messages = new Messages();
        messages.setClientId(messageDto.getClientId());
        messages.setText(messageDto.getText());

        messagesDao.save(messages);
        if (messages == null) {
            LOG.debug(LogServiceMessageUtil.getFailDebugMessage(SAVE_METHOD_NAME, DAO));
        }
        LOG.info(LogServiceMessageUtil.getSuccessInfoMessage(SAVE_METHOD_NAME, DAO));
    }
}
