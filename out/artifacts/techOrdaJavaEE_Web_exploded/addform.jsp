<form action="/add-book" method="POST">
    <div class="row">
        <div class="col-12">
            <label>NAME : </label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="text" class="form-control" name="book_name">
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <label>AUTHOR : </label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="text" class="form-control" name="book_author">
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
                <option value="">Fantasy</option>
                <option value="">Roman</option>
                <option value="">Biography</option>
                <option value="">Horror</option>
                <option value="">Comics</option>
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
                <option><%=i%></option>
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
            <textarea rows="5" class="form-control" name="book_description"></textarea>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <button class="btn btn-dark" style="background:#1e1961;">ADD BOOK</button>
        </div>
    </div>
</form>