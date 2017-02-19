/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 14:05
 * Class:       PACKAGE_NAME.App
 */

import com.pay4later.Controller.Controller;
import com.pay4later.model.UsersLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;


public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {

        logger.info("Setting properties file: " + args[0]);

        String appEnv = args[0];
        System.getProperties().load(new FileInputStream(appEnv));

        File source = new File(System.getProperty("users.source"));
        File destination = new File(System.getProperty("users.destination"));

        logger.info("Creating a Controller -- Handles the application logic");
        Controller ctrl = new Controller(source, destination);

        logger.info("Start to Deserialize");
        ctrl.deserializeUsers();

        logger.info("Start to Serialize");
        ctrl.serializeUsers(UsersLibrary.getInstance().getAll());

    }
}

