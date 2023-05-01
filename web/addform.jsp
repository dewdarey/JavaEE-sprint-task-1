<form action="/add-task" method="POST">
    <div class="row">
        <div class="col-12">
            <label>Name</label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="text" class="form-control" name="task_name">
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <label>Deadline</label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <input type="text" class="form-control" name="task_deadline">
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <label>Done</label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <select class="form-select" name="task_process">
                <option value="">Yes</option>
                <option value="">No</option>
            </select>
        </div>
    </div>
        <div class="row mt-3">
        <div class="col-12">
            <label>Description</label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <textarea rows="5" class="form-control" name="task_description"></textarea>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <button class="btn btn-outline-success">ADD TASK</button>
        </div>
    </div>
</form>