package TestProject.controller;

import TestProject.controller.utils.LogControllerMessageUtil;
import TestProject.dto.MessageDto;
import TestProject.service.MessagesService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/messages")

public class MessageServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientServlet.class.getName());
    private static final String SERVLET_NAME = "MESSAGE SERVLET";
    private final MessagesService messagesService = new MessagesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("messages", messagesService.findAllMessages());
            req.getRequestDispatcher("views/messages.jsp").forward(req, resp);
        } catch (ServletException e) {
            LOG.error(LogControllerMessageUtil.getServletErrorMessage(SERVLET_NAME));
            e.printStackTrace();

        } catch (IOException e) {
            LOG.error(LogControllerMessageUtil.getIOExceptionMessage(SERVLET_NAME));
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();

            MessageDto messageDto = new MessageDto();
            messageDto.setClientId((Integer) session.getAttribute("clientId"));
            messageDto.setText(req.getParameter("text"));
            messagesService.save(messageDto);

            req.getRequestDispatcher("views/messages.jsp").forward(req, resp);
        } catch (ServletException e) {
            LOG.error(LogControllerMessageUtil.getServletErrorMessage(SERVLET_NAME));
            e.printStackTrace();

        } catch (IOException e) {
            LOG.error(LogControllerMessageUtil.getIOExceptionMessage(SERVLET_NAME));
            e.printStackTrace();
        }
    }

}
