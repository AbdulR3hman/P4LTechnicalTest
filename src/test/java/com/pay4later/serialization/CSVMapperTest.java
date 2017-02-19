package com.pay4later.serialization;

import com.pay4later.model.User;
import com.pay4later.serialization.CSVMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 20:38
 * Class:       CSVMapperTest
 */
public class CSVMapperTest {

    private CSVMapper mapper;
    private User tUser;

    @Before
    public void setUp() throws Exception {
        mapper = new CSVMapper();

        tUser = new User(99, "John", "Doe", "john99", "Demigod");
        tUser.setLastLoginTime("01-01-2011 01:01:14");
    }

    @Test
    public void deserialisePersons() throws Exception {
        File csvFile = new File("/Users/abdulr3hman/temp/data/users.csv");
        List<User> users = mapper.deserializePersons(csvFile);
        assertTrue(users.size() > 0);
    }

    @Test
    public void serialisePersons() throws Exception {
        File csvFile = new File(getClass().getResource("/test/").getFile() + "usersOutTest.csv");
        List<User> users = new LinkedList<>();
        users.add(tUser);
        users.add(tUser);
        users.add(tUser);
        users.add(tUser);

        mapper.serialisePersons(csvFile,users);

    }


}