package com.pay4later.serialization.marshalling;

import com.pay4later.model.User;

import java.io.File;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 20:37
 * Class:       com.pay4later.serialization.marshalling.CSVMapper
 */
public class CSVMapper implements UserMapper {
    @Override
    public void serialisePersons(File destination, List<User> people) {

    }

    @Override
    public List<User> deserialisePersons(File source) {
        return null;
    }
}
