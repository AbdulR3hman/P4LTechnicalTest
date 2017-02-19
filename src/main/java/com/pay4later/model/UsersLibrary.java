package com.pay4later.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 23:22
 * Class:       com.pay4later.model.UsersLibrary
 * Library that will hold all current users in memory. Collected from all files -- CVS/Json/XML
 */
public class UsersLibrary {

    private static volatile UsersLibrary _usersLib = null;
    private List<User> users;

    private UsersLibrary() {
        users = new LinkedList<>();
    }

    /**
     * @return an singleton instance of hte users library
     */
    public static UsersLibrary getInstance() {
        if (_usersLib == null) {
            synchronized (UsersLibrary.class) {
                if (_usersLib == null) {
                    _usersLib = new UsersLibrary();
                }
            }
        }
        return _usersLib;
    }


    /**
     * Add user to the library
     *
     * @param user
     */
    public void add(User user) {
        users.add(user);
    }

    /**
     * Add a list of users
     * @param users
     */
    public void addAll(List<User> users) {
        this.users.addAll(users);
    }

    /**
     * @return list of all users
     */
    public List<User> getAll() {
        return users;
    }

    /**
     * @param index
     * @return a user
     */
    public User get(int index) {
        return users.get(index);
    }
}
