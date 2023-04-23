package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Task;
import kz.bitlab.techorda.db.TaskDBManager;

import java.io.IOException;

@WebServlet(value = "/add-task")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("task_name");
        String author = request.getParameter("task_deadline");
        String genre = request.getParameter("task_process");
        String description = request.getParameter("task_description");

        Task task = new Task();
        task.setName(name);
        task.setDeadline(deadline);
        task.setProcess(process);
        task.setDescription(description);

        TaskDBManager.addTask(task);

        response.sendRedirect("/");
    }
}
