package kz.bitlab.techorda.db;

import kz.bitlab.techorda.model.User;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tech_orda_db",
                    "root",
                    "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Task> getTasks() {

        ArrayList<Task> tasks = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM tasks"
            );

            ResultSet resultSet = statement.executeQuery(); // Чтобы подтянуть данные из DB

            while (resultSet.next()) {

                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDeadline(resultSet.getString("deadline"));
                task.setProcess(resultSet.getString("process"));
                task.setDescription(resultSet.getString("description"));
                tasks.add(task);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public static void addTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO tasks (name, deadline, process, description) " +
                    "VALUES (?, ?, ?, ?)");
            statement.setString(1, task.getName());
            statement.setString(2, task.getDeadline());
            statement.setString(3, task.getProcess());
            statement.setString(4, task.getDescription());

            statement.executeUpdate();      // Чтобы отправить данные DB
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Task getTask(int id) {

        Task task = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM tasks WHERE id = ? LIMIT 1");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDeadline(resultSet.getString("deadline"));
                task.setProcess(resultSet.getString("process"));
                task.setDescription(resultSet.getString("description"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return task;
    }

    public  static void updateTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE tasks " +
                    "SET name = ?, " +
                    "deadline = ?, " +
                    "process = ?, " +
                    "description = ? " +
                    "WHERE id = ?");

            statement.setString(1, task.getName());
            statement.setString(2, task.getDeadline());
            statement.setString(3, task.getProcess());
            statement.setString(4, task.getDescription());
            statement.setInt(5, task.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM tasks WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String email) {

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
