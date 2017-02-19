/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 14:05
 * Class:       PACKAGE_NAME.App
 */

import com.pay4later.Controller.Controller;
import com.pay4later.model.UsersLibrary;

import java.io.File;


public class App {


    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        App app = new App();
        app.run();
    }

    private void run() throws Exception {
        File source = new File("/Users/abdulr3hman/temp/data");
        File destination = new File("/Users/abdulr3hman/temp/out");

        Controller ctrl = new Controller(source, destination);
        ctrl.deserializeUsers();
        ctrl.serializeUsers(UsersLibrary.getInstance().getAll());


    }
}

