/**
 * Created:     by Abdul Al-Faraj
 * Date:        18/02/2017 -- 14:05
 * Class:       PACKAGE_NAME.App
 */

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;


public class App {


    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        App app = new App();
        app.run();
    }

    private void run() throws Exception {


    }

    public class Simple {
        public int x = 1;
        public int y = 2;
    }
}

