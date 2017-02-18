package com.pay4later.serialization.marshalling;

import com.pay4later.model.User;

import java.io.File;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 18:33
 * Class:       com.pay4later.serialization.marshalling.UserMapper
 */
public interface UserMapper {
    void serialisePersons(File destination, List<User> people);
    List<User> deserialisePersons(File source);
}
