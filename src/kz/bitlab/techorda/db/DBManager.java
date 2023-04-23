package kz.bitlab.techorda.db;

import kz.bitlab.techorda.model.User;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<User> users = new ArrayList<>();
    static {
        User user1 = new User("Ilyas", "Zhuanyshev", "IT", 550000);
        User user2 = new User("Aybek", "Bagit", "Management", 650000);
        User user3 = new User("Alibek", "Serikov", "HR", 350000);
        User user4 = new User("Serzhan", "Berikov", "IT", 450000);
        User user5 = new User("Madina", "Assetova", "PR", 350000);
        User user6 = new User("Anel", "Mukhamejanova", "Management", 400000);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
    }

    public static ArrayList<User> getAllUsers() {
        return users;
    }
}
