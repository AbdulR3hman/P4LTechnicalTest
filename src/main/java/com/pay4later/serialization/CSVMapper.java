package com.pay4later.serialization;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.opencsv.CSVWriter;
import com.pay4later.model.User;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 20:37
 * Class:       com.pay4later.serialization.CSVMapper
 */
public class CSVMapper implements UserMapper {

    private CsvMapper personMapper;

    public CSVMapper() {
        personMapper = new CsvMapper();
        personMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
    }

    @Override
    public void serialisePersons(File destination, List<User> users) {
        String[] headers = {"User ID", "First Name", "Last Name", "Username", "User Type", "Last Login Time"};

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(destination), ',', CSVWriter.NO_QUOTE_CHARACTER);
            writer.writeNext(headers);

            for (User usr : users)
                writer.writeNext(usr.toStringArray());

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> deserializePersons(File source) {

        List<User> users = new LinkedList<>();
        try {
            MappingIterator<String[]> it = personMapper.readerFor(String[].class).readValues(source);

            //Skips the headers
            it.next();

            while (it.hasNext()) {
                String[] usr = it.next();
                User u = new User(Integer.valueOf(usr[0]), usr[1], usr[2], usr[3], usr[4]);
                u.setLastLoginTime(usr[5]);
                users.add(u);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return users;
    }
}
