package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;
import java.sql.PreparedStatement;

@WebServlet(value = "/add-task")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("task_name");
        String deadline = request.getParameter("task_deadline");
        String process = request.getParameter("task_process");
        String description = request.getParameter("task_description");

        Task task = new Task();
        task.setName(name);
        task.setDeadline(deadline);
        task.setProcess(process);
        task.setDescription(description);

        DBConnection.addTask(task);

        response.sendRedirect("/");
    }

}
