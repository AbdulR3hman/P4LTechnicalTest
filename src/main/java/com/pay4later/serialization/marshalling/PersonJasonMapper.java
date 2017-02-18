package com.pay4later.serialization.marshalling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.pay4later.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 15:33
 * Class:       com.pay4later.serialization.marshalling.PersonJasonMapper
 */
public class PersonJasonMapper implements PersonMapper {

    private ObjectMapper personMapper;

    /**
     * write @param persons to @param jason file
     */
    public PersonJasonMapper() {
        personMapper = new ObjectMapper();
    }

    /**
     * write @param persons to @param destination json file
     */
    public void serialisePersons(File destination, List<Person> people) {
        try {
            personMapper.writeValue(destination, people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get's a group of people based on a file. if file empty; return an empty file
     *
     * @param source
     * @return collection List of Person
     */
    public List<Person> deserialisePersons(File source) {
        List<Person> people = new LinkedList<Person>();

        try {
            people = personMapper.readValue(source, new TypeReference<List<Person>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }
}
