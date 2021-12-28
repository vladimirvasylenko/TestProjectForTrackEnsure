package TestProject.service;

import TestProject.dao.MessagesDao;
import TestProject.dto.MessageDto;
import TestProject.entities.Messages;

import java.util.ArrayList;
import java.util.List;

public class MessagesService {

    private final MessagesDao messagesDao;

    public MessagesService() {
        messagesDao = new MessagesDao();
    }

    public List<MessageDto> findAllMessages() {
        List<Messages> message = messagesDao.findAllMessages();
        List<MessageDto> result = new ArrayList<>();

        for (Messages messages : message) {
            MessageDto dto = new MessageDto();
            dto.setText(messages.getClientName());
            dto.setText(messages.getText());
            result.add(dto);
        }

        return result;
    }

    public void save(MessageDto messageDto) {
        Messages messages = new Messages();
        messages.setClientId(messageDto.getClientId());
        messages.setText(messageDto.getText());

        messagesDao.save(messages);
    }
}
