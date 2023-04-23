package kz.bitlab.techorda.db;

import java.util.ArrayList;

public class TaskDBManager {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    private static int id = 6;

    static {
        tasks.add(
                new Task(
                        1,
                        "Создать Веб приложение на JAVA EE",
                        "23.10.2021",
                        "Да",
                        "Harry Potters survives after Voldemot's attack"
                )
        );
        tasks.add(
                new Task(
                        2,
                        "Убраться дома и закупить продукты",
                        "25.10.2021",
                        "Да",
                        "Sirius Black escaped from Azkaban and he is a godfather of Harry Potter"
                )
        );
        tasks.add(
                new Task(
                        3,
                        "Выполнить все домашние задания",
                        "28.10.2021",
                        "Нет",
                        "Bella moves to Alaska from Arizona to her dad"
                )
        );
        tasks.add(
                new Task(
                        4,
                        "Записаться на качку",
                        "12.12.2021",
                        "Нет",
                        "This story about Abay Kunanbayev's life"
                )
        );
        tasks.add(
                new Task(
                        5,
                        "Учит Итальянский",
                        "23.10.2021",
                        "Нет",
                        "This story about Zlatan's childhood, about AJAX, Juventus and Mino Raiola"
                )
        );
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTask(int id) {
        return tasks
                .stream()
                .filter(task -> task.getId()==id)
                .findFirst()
                .orElse(null);
    }

    public static void updateTask(Task task) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getId()==task.getId()){
                tasks.set(i, task);
                break;
            }
        }
    }

    public static void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId()==id) {
                tasks.remove(i);
                break;
            }
        }
    }
}
