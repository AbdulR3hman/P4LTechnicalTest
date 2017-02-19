package com.pay4later.Controller;

import com.pay4later.model.User;
import com.pay4later.model.UsersLibrary;
import com.pay4later.serialization.XMLMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        19/02/2017 -- 00:32
 * Class:       com.pay4later.Controller.ControllerTest
 */
public class ControllerTest {


    private List<String> users;
    private UsersLibrary library;
    private Controller controller;
    private File source;
    private File destination;

    @Before
    public void setUp() throws Exception {
        users = new LinkedList<>();
        library = UsersLibrary.getInstance();

        source = new File(getClass().getResource("/data").getPath());
        destination = new File(getClass().getResource("/out").getPath());

        controller = new Controller(source, destination);
    }

    //ignore these tests due to multi-concurrency access to the library
    //making testing it not an easy task, so I will not test for now, due to time
    @Ignore
    public void deserializeUsers() throws Exception {

        //make sure it's still empty
        assertTrue(library.getAll().isEmpty());

        controller.deserializeUsers();

        assertTrue(!library.getAll().isEmpty());
        assertEquals(library.getAll().size(), 10);

    }

    @Ignore
    public void serializeUsers() throws Exception {
        controller.deserializeUsers();
        controller.serializeUsers(library.getAll());

        XMLMapper mapper = new XMLMapper();
        List<User> usrs = mapper.deserializePersons(new File(destination + destination.separator + "users.xml"));

        assertTrue(!usrs.isEmpty());
    }

}