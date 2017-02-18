package com.pay4later.serialization.marshalling;

import com.pay4later.model.User;
import com.pay4later.serialization.CSVMapper;
import com.pay4later.serialization.UserMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 20:38
 * Class:       com.pay4later.serialization.marshalling.CSVMapperTest
 */
public class CSVMapperTest {

    private UserMapper mapper;
    private User tUser;

    @Before
    public void setUp() throws Exception {
        mapper = new CSVMapper();

        tUser = new User(99, "John", "Doe", "john99", "Demigod");
        tUser.setLastLoginTime("01-01-2011 01:01:14");
    }

    @Test
    public void deserialisePersons() throws Exception {
        File csvFile = new File(getClass().getResource("/test/Users.csv").getFile());
        List<User> users = mapper.deserialisePersons(csvFile);
    }

    @Test
    public void serialisePersons() throws Exception {
        File csvFile = new File(getClass().getResource("/test/").getFile() + "UsersOutput.csv");
        List<User> users = new LinkedList<>();
        users.add(tUser);

        mapper.serialisePersons(csvFile,users);

    }


}