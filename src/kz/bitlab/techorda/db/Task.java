package kz.bitlab.techorda.db;

public class Task {
    private int id;
    private String name;
    private String deadline;
    private String process;
    private String description;

    public Task() {
    }

    public Task(int id, String name, String deadline, String process, String description) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.process = process;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
