package kz.bitlab.techorda.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.Task;

import java.io.IOException;

@WebServlet(value = "/save-task")
public class SaveTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("task_id"));
        String name = request.getParameter("task_name");
        String deadline = request.getParameter("task_deadline");
        String process = request.getParameter("task_process");
        String description = request.getParameter("task_description");

        Task task = DBConnection.getTask(id);
        if(task!=null) {
            task.setName(name);
            task.setDeadline(deadline);
            task.setProcess(process);
            task.setDescription(description);
            DBConnection.updateTask(task);
            response.sendRedirect("/details?task_id="+id);
        } else {
            response.sendRedirect("/");
        }
    }
}
