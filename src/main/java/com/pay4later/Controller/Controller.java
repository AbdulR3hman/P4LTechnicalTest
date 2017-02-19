package com.pay4later.Controller;

import com.pay4later.model.User;
import com.pay4later.model.UsersLibrary;
import com.pay4later.serialization.Mapper;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 23:22
 * Class:       com.pay4later.Controller.Controller
 */
public class Controller {

    private UsersLibrary library;
    private Mapper mapper;

    private File destination;
    private File source;

    /**
     * @param sourceDirectory
     * @param destinationDirectory
     */
    public Controller(File sourceDirectory, File destinationDirectory) {
        library = UsersLibrary.getInstance();
        mapper = new Mapper();

        source = sourceDirectory;
        destination = destinationDirectory;
    }

    /**
     * Collect all users from all file types and store them in the library
     *
     * @return
     */
    public int deserializeUsers() {
        File[] files = source.listFiles();
        for (File file : files) {
            List<User> userList = mapper.deserialize(file);
            if (userList != null && !userList.isEmpty())
                library.addAll(userList);
        }

        return library.getAll().size();
    }

    /**
     * Serialize list of users as long they're not empty
     *
     * @param users
     */
    public void serializeUsers(List<User> users) {
        if (!users.isEmpty())
            mapper.serialize(users, destination);
    }


    public void sortLibrary(){
        library.sort();
    }
}
