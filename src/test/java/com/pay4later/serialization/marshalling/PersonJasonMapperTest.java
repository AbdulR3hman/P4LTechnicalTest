package com.pay4later.serialization.marshalling;

import com.pay4later.model.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 16:37
 * Class:       com.pay4later.serialization.marshalling.PersonJasonMapperTest
 */
public class PersonJasonMapperTest {

    private PersonJasonMapper mapper;
    private Person tPerson;
    private List<Person> people;

    @Before
    public void setUp() throws Exception {
        mapper = new PersonJasonMapper();

        tPerson = new Person(99, "John", "Doe", "john99", "Demigod");
        tPerson.setLastLoginTime("01-01-2011 01:01:14");

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void serialisePersons() {
        File file = new File(getClass().getResource("/test/").getPath() + "peopleOutTest.json");
        people = new LinkedList<Person>();
        people.add(tPerson);

        mapper.serialisePersons(file, people);
    }

    @Test
    public void deserialisePersons() {
        people = null;
        Person johnDoe = null;
        File file = new File(getClass().getResource("/test/People.json").getFile());

        people = mapper.deserialisePersons(file);

        assertTrue(people.size() > 0);
        for (Person p : people) {
            johnDoe = p;
            break;
        }
        assertEquals(johnDoe.getFirstName(), "John");
    }

    @Test
    public void TestunMarshallPeopleWithEmptyFile() {
        File file = new File(getClass().getResource("/test/Empty.json").getFile());
        people = mapper.deserialisePersons(file);
        assertTrue(people.isEmpty());

    }

}