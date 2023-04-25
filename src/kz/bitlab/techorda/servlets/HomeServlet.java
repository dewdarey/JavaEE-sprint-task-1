package kz.bitlab.techorda.servlets;

import kz.bitlab.techorda.db.Task;
import kz.bitlab.techorda.db.TaskDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Task> tasks = TaskDBManager.getTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();*/


//        Task 1-1
        /*for (int i = 0; i < 10; i++) {
            out.print("<h1>"+ i +" Hello Bitlab "+i+"</h1>");
        }*/

//        Task 1-2
        /*out.print("<br>");
        out.print("<table>");
        out.print("<thead>");
        out.print("<tr>");
        out.print("<th>NAME</th>");
        out.print("<th>SURNAME</th>");
        out.print("<th>DEPARTMENT</th>");
        out.print("<th>SALARY</th>");
        out.print("</tr>");
        out.print("</thead>");
        out.print("<tbody>");

        for (User user : users) {
            out.print("<tr>");
            out.print("<td>");
            out.print(user.getName());
            out.print("</td>");
            out.print("<td>");
            out.print(user.getSurname());
            out.print("</td>");
            out.print("<td>");
            out.print(user.getDepartment());
            out.print("</td>");
            out.print("<td>");
            out.print(user.getSalary());
            out.print("</td>");
        }

        out.print("</tbody>");
        out.print("</table>");*/
    }
}
