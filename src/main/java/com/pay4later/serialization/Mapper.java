package com.pay4later.serialization;

import com.pay4later.model.User;

import java.io.File;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        19/02/2017 -- 00:16
 * Class:       com.pay4later.serialization.Mapper
 */
public class Mapper {

    private UserMapper json;
    private UserMapper xml;
    private UserMapper csv;

    public Mapper() {
        json = new JsonMapper();
        xml = new XMLMapper();
        csv = new CSVMapper();
    }

    /**
     * Deserialize  @param file by the extension
     *
     * @return List of Users, or null if nothing found.
     */
    public List<User> deserialize(File file) {

        if (file.getName().endsWith(".json")) {
            return json.deserialisePersons(file);
        } else if (file.getName().endsWith(".xml")) {
            return xml.deserialisePersons(file);
        } else if (file.getName().endsWith(".csv")) {
            return csv.deserialisePersons(file);
        }
        //If no match found so far, return a null
        return null;
    }

    /**
     * serialize (or marshalles in the case of the CSV) all users to Json, CSV, and XML
     * @param users
     * @param destination
     */
    public void serialize(List<User> users, File destination) {
        json.serialisePersons(destination, users);
        xml.serialisePersons(destination, users);
        csv.serialisePersons(destination, users);
    }
}
