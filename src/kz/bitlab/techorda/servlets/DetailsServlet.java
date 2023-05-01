package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("task_id"));
        } catch (Exception e) {
        }

        Task task = DBConnection.getTask(id);
        request.setAttribute("task", task);
        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}
