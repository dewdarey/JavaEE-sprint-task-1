<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Title</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>

        <div class="container mt-5">
            <div class="row mt-3">
                <div class="col-12">
                    <button type="button" class="btn btn-dark btn-sm" data-bs-toggle="modal" data-bs-target="#addTask" style="background:#1e1961;">
                        + Добавить задание
                    </button>

                    <div class="modal fade" id="addTask" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Новое задание</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <%@include file="addform.jsp"%>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                                    <button type="button" class="btn btn-primary">Добавить</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col-12">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NAME</th>
                                <th>AUTHOER</th>
                                <th>GENRE</th>
                                <th>PRICE</th>
                                <th style="width: 10%">DETAILS</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Task> tasks = (ArrayList<Task>) request.getAttribute("tasks");
                                if (tasks != null) {
                                    for (Task task : tasks) {
                            %>
                                <tr>
                                    <td><%=task.getId()%></td>
                                    <td><%=task.getName()%></td>
                                    <td><%=task.getDeadline()%></td>
                                    <td><%=task.getProcess()%></td>
                                    <td>
                                        <a class="btn btn-dark btn-sm" style="background:#1e1961;" href="/details?task_id=<%=task.getId()%>">Детали</a>
                                    </td>
                                </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
