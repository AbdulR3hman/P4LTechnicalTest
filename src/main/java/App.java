/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 14:05
 * Class:       PACKAGE_NAME.App
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pay4later.model.Person;

import java.io.File;


public class App {


    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        App app = new App();
        app.run();
    }

    private void run() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(new File((getClass().getResource("test/People.json").getFile())), Person.class);
        System.out.println(person);
    }
}
