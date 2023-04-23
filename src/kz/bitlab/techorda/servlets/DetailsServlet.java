package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.Task;
import kz.bitlab.techorda.db.TaskDBManager;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("book_id"));
        } catch (Exception e) {
        }

        Task book = TaskDBManager.getBook(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}
