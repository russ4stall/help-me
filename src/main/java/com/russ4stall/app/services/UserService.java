package com.russ4stall.app.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import com.russ4stall.app.models.User;

public class UserService {
    private Logger logger = Logger.getLogger("Users");
    private CopyOnWriteArrayList<User> users;

    public UserService() {
        users = new CopyOnWriteArrayList<>();
    }

    public User addUser(User user) {
        user.setId(getNextId());
        users.add(user);
        
        return user;
    }

    public Object[] getObjectArray() {
        return users.toArray();
    }

    public List<User> getList() {
        return users;
    }

    public int getCount() {
        return users.size();
    }

    public void populateUsers() {
        User user1 = new User("Russ", 28);
        User user2 = new User("Ashlyn", 30);
        User user3 = new User("Maylene", 5);
        
        addUser(user1);
        addUser(user2);
        addUser(user3);
    }

    private int getNextId() {
        int id = 0;

        for (User user : users) {
            if (user.getId() > id) {
                id = user.getId();
            }
        }

        return ++id;
    }
}