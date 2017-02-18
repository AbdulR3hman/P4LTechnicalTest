package com.pay4later.serialization.marshalling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pay4later.model.Person;

import java.io.File;
import java.io.IOException;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 15:33
 * Class:       com.pay4later.serialization.marshalling.PersonJasonMapper
 */
public class PersonJasonMapper {

    private ObjectMapper personMapper;

    public PersonJasonMapper() {
        personMapper = new ObjectMapper();
    }


    /**
     *
     * @param file name that points to the json file.
     * @return Person object if file found, otherwise null
     */
    public Person unmarshallPerson(File file) {
        Person person;

        try {
            person = personMapper.readValue(file, Person.class);
        } catch (IOException eio) {
            person = null;
            eio.printStackTrace();
        }
        return person;
    }



}
