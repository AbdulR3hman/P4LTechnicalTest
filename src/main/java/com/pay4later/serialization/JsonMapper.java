package com.pay4later.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pay4later.model.User;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 15:33
 * Class:       com.pay4later.serialization.JsonMapper
 */
public class JsonMapper implements UserMapper<User> {

    private ObjectMapper personMapper;

    /**
     * write @param persons to @param jason file
     */
    public JsonMapper() {
        personMapper = new ObjectMapper();
        personMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy.SNAKE_CASE);
        personMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    }

    /**
     * write @param persons to @param destination json file
     */
    public void serialisePersons(File destination, List<User> people) {
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
     * @return collection List of User
     */
    public List<User> deserializePersons(File source) {
        List<User> people = new LinkedList<User>();

        try {
            people = personMapper.readValue(source, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }
}
