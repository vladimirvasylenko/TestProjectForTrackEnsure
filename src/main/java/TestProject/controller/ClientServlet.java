package TestProject.controller;

import TestProject.dao.ClientDao;
import TestProject.dto.ClientDto;
import TestProject.entities.Client;
import TestProject.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/clients")

public class ClientServlet extends HttpServlet {
    private final ClientService clientService = new ClientService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        ClientDto clientDto = new ClientDto();
        clientDto.setName(req.getParameter("name"));
        clientService.save(clientDto);

        ClientDao clientDao = new ClientDao();
        Client client = clientDao.findClientsId().get(0);

        session.setAttribute("clientId", client.getId());
        req.getRequestDispatcher("views/messages.jsp").forward(req, resp);
    }
}
