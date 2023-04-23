<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
    <%@include file="navbar.jsp"%>

    <div class="container mt-5 pb-5">
        <%
            Book book = (Book) request.getAttribute("book");
            if(book!=null) {
        %>

        <div class="row">
            <div class="col-6 mx-auto">
                <div class="row">
                    <div class="col-12">
                        <label>NAME : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=book.getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>AUTHOR : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=book.getAuthor()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>GENRE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=book.getGenre()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>PRICE : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=book.getPrice()%> KZT">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>DESCRIPTION : </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea class="form-control" readonly rows="10"><%=book.getDescription()%></textarea>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editTask" >
                            Изменить
                        </button>
                        <button type="button" class="btn btn-danger btn-sm ms-2" data-bs-toggle="modal" data-bs-target="#deleteTask">
                            Удалить
                        </button>

                    </div>
                </div>
                <div class="modal fade" id="deleteTask" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/delete-task" method="post">
                                <input type="hidden" name="id" value="<%=book.getId()%>">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5">Подтвердите удаление</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <h5 class="text-center">Вы уверены что хотите удалить?</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Нет</button>
                                    <button class="btn btn-danger">Да</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="editTask" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Новое задание</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="/save-task" method="POST">
                                    <input type="hidden" name="book_id" value="<%=book.getId()%>">
                                    <div class="row">
                                        <div class="col-12">
                                            <label>NAME : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <input type="text" class="form-control" name="book_name" value="<%=book.getName()%>">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>AUTHOR : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <input type="text" class="form-control" name="book_author" value="<%=book.getAuthor()%>">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>GENRE : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <select class="form-select" name="book_genre">
                                                <option <%=(book.getGenre().equals("Fantasy")?"selected":"")%> >Fantasy</option>
                                                <option <%=(book.getGenre().equals("Roman")?"selected":"")%> >Roman</option>
                                                <option <%=(book.getGenre().equals("Biography")?"selected":"")%> >Biography</option>
                                                <option <%=(book.getGenre().equals("Horror")?"selected":"")%> >Horror</option>
                                                <option <%=(book.getGenre().equals("Comics")?"selected":"")%> >Comics</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>PRICE : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <select class="form-select" name="book_price">
                                                <%
                                                    for (int i = 0; i <= 100000; i+=1000) {
                                                %>
                                                <option <%=(i==book.getPrice()?"selected":"")%>><%=i%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>DESCRIPTION : </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <textarea rows="10" class="form-control" name="book_description"><%=book.getDescription()%></textarea>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <button class="btn btn-success">Сохранить</button>
                                        </div>
                                    </div>
                                </form>
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

        <%
            } else {
        %>
            <h3 class="text-center">
                ЗАДАНИЕ НЕ НАЙДЕНО
            </h3>
        <%
            }
        %>
    </div>
    </body>
</html>
