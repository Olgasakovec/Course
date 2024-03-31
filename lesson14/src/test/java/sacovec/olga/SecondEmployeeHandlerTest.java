package sacovec.olga;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static sacovec.olga.ClientXmlAuto.rootPath;

public class SecondEmployeeHandlerTest {

    @Test
    public void testLastJobEmployee1() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File file = new File(rootPath + "src/test/java/employee.xml");
        EmployeeHandler handler1 = new EmployeeHandler();
        parser.parse(file,handler1);
        System.out.println(handler1.getLastNameEmployee());
        String lastNameEmployee = handler1.getLastNameEmployee();

        File file2 = new File(rootPath + "src/test/java/employee2.xml");
        EmployeeHandler handler2 = new EmployeeHandler();
        parser.parse(file2,handler2);
        System.out.println(handler2.getLastNameEmployee2());
        String lastNameEmployee2 = handler2.getLastNameEmployee2();
        assertNotEquals(lastNameEmployee, lastNameEmployee2);
    }
}
