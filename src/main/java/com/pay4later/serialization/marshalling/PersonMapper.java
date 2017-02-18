package com.pay4later.serialization.marshalling;

import com.pay4later.model.Person;

import java.io.File;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 18:33
 * Class:       com.pay4later.serialization.marshalling.PersonMapper
 */
public interface PersonMapper {
    void serialisePersons(File destination, List<Person> people);
    List<Person> deserialisePersons(File source);
}
