package TestProject.controller;

import TestProject.dto.MessageDto;
import TestProject.service.ClientService;
import TestProject.service.MessagesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet ("/messages")

public class MessageServlet extends HttpServlet {
    private final MessagesService messagesService = new MessagesService();
    private final ClientService clientService = new ClientService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", messagesService.findAllMessages());
        req.getRequestDispatcher("views/messages.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        MessageDto messageDto = new MessageDto();
        messageDto.setClientId((Integer) session.getAttribute("clientId"));
        messageDto.setText(req.getParameter("text"));
        messagesService.save(messageDto);

        req.getRequestDispatcher("views/messages.jsp").forward(req, resp);
    }

}
