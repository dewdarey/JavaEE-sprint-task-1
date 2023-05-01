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
        <div class="container mt-3">
            <div class="row">
                <div class="col-6 mx-auto">
                    <h1>Hello <%=currentUser.getFullName()%></h1>
                </div>
            </div>
        </div>
    </body>
</html>
