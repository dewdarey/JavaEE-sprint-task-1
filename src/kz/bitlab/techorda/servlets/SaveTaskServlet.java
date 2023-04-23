package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.TaskDBManager;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;

@WebServlet(value = "/save-task")
public class SaveTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("book_id"));
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        String genre = request.getParameter("book_genre");
        double price = Double.parseDouble(request.getParameter("book_price"));
        String description = request.getParameter("book_description");

        Task book = TaskDBManager.getBook(id);
        if(book!=null) {
            book.setName(name);
            book.setAuthor(author);
            book.setPrice(price);
            book.setGenre(genre);
            book.setDescription(description);
            TaskDBManager.updateBook(book);
            response.sendRedirect("/details?book_id="+id);
        } else {
            response.sendRedirect("/");
        }
    }
}
