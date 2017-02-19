package com.pay4later.model;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 23:31
 * Class:       com.pay4later.model.UsersLibraryTest
 */
public class UsersLibraryTest {

    private UsersLibrary library;
    private User tUser;

    @Before
    public void setUp() throws Exception {
        library = UsersLibrary.getInstance();

        tUser = new User(99, "John", "Doe", "john99", "Demigod");
        tUser.setLastLoginTime("01-01-2011 01:01:14");
    }

    @Test
    public void getInstance() throws Exception {
        UsersLibrary library2 = UsersLibrary.getInstance();
        assertEquals(library, library2);
    }

    @Test
    public void add() throws Exception {
        library.add(tUser);
        assertEquals(library.get(0), tUser);
    }

    @Test
    public void getAll() throws Exception {
        List<User> usrs = new LinkedList<>();
        usrs.add(tUser);

        library.add(tUser);

        assertEquals(library.getAll(), usrs);
    }

}