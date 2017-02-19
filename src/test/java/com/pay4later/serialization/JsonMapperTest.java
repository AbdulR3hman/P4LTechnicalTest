package com.pay4later.serialization;

import com.pay4later.model.User;
import com.pay4later.serialization.JsonMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 16:37
 * Class:       JsonMapperTest
 */
public class JsonMapperTest {

    private JsonMapper mapper;
    private User tUser;
    private List<User> people;

    @Before
    public void setUp() throws Exception {
        mapper = new JsonMapper();

        tUser = new User(99, "John", "Doe", "john99", "Demigod");
        tUser.setLastLoginTime("01-01-2011 01:01:14");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void serialisePersons() throws Exception{
        File file = new File(getClass().getResource("/test/").getPath() + "usersOutTest.json");
        people = new LinkedList<User>();
        people.add(tUser);

        mapper.serialisePersons(file, people);
    }

    @Test
    public void deserialisePersons() throws Exception{
        people = null;
        User johnDoe = null;
        File file = new File("/Users/abdulr3hman/temp/data/users.json");

        people = mapper.deserializePersons(file);

        assertTrue(people.size() > 0);
        for (User p : people) {
            johnDoe = p;
            break;
        }
        assertEquals(johnDoe.getFirstName(), "Joe");
    }

//    @Test
    public void TestunMarshallPeopleWithEmptyFile() {
        File file = new File(getClass().getResource("/test/Empty.json").getFile());
        people = mapper.deserializePersons(file);
        assertTrue(people.isEmpty());

    }

}