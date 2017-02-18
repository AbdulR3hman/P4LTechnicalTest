package com.pay4later.serialization.marshalling;

import com.pay4later.model.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 16:37
 * Class:       com.pay4later.serialization.marshalling.PersonJasonMapperTest
 */
public class PersonJasonMapperTest {

    private PersonJasonMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new PersonJasonMapper();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void unmarshallPerson() throws Exception {
        Person person = null;
        File file = new File(getClass().getResource("/test/abdul.json").getFile());

        person = mapper.unmarshallPerson(file);

        assertTrue(person != null);
        assertTrue(file.exists());

        assertEquals(person.getFirstName(), "Abdul");

    }

}