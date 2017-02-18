package com.pay4later.serialization.marshalling;

import com.pay4later.model.User;
import com.pay4later.serialization.UserMapper;
import com.pay4later.serialization.XMLMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 18:54
 * Class:       com.pay4later.serialization.marshalling.XMLMapperTest
 */
public class XMLMapperTest {

    private UserMapper mapper;
    private User tUser;
    private List<User> people;

    @Before
    public void setUp() throws Exception{
        mapper = new XMLMapper();

        tUser = new User(99, "John", "Doe", "john99", "Demigod");
        tUser.setLastLoginTime("01-01-2011 01:01:14");
    }

    @Test
    public void serialisePersons() throws Exception {
        File file = new File(getClass().getResource("/test/").getPath() + "usersOutTest.xml");
        people = new LinkedList<>();
        people.add(tUser);
        people.add(tUser);
        people.add(tUser);

        mapper.serialisePersons(file, people);

        List<User> _users = mapper.deserialisePersons(file);

        assertEquals(_users, people);

    }

    @Test
    public void deserialisePersons() throws Exception {

        people = null;
        User johnDoe = null;
        File file = new File(getClass().getResource("/test/Users.xml").getFile());

        people = mapper.deserialisePersons(file);

        assertTrue(people.size() > 0);
        for (User p : people) {
            johnDoe = p;
            break;
        }
        assertEquals(johnDoe.getFirstName(), "John");
    }

}