package com.pay4later.serialization;

import com.pay4later.model.User;

import java.io.File;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 18:33
 * Class:       com.pay4later.serialization.UserMapper
 */
public interface UserMapper<T> {
    void serialisePersons(File destination, List<T> people);
    List<T> deserializePersons(File source);
}
