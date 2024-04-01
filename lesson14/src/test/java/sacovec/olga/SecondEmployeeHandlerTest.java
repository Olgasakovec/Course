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
    public void testLastNameEmployee() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File file1 = new File(rootPath + "/src/test/java/sacovec.olga/employee.xml");
        SecondEmployeeHandler handler1 = new SecondEmployeeHandler();
        parser.parse(file1,handler1);
        System.out.println(handler1.getLastNameEmployee());
        String lastNameEmployee = handler1.getLastNameEmployee();

        File file2 = new File(rootPath + "/src/test/java/sacovec.olga/employee2.xml");
        SecondEmployeeHandler handler2 = new SecondEmployeeHandler();
        parser.parse(file2,handler2);
        System.out.println(handler2.getLastNameEmployee());
        String lastNameEmployee2 = handler2.getLastNameEmployee();
        assertNotEquals(lastNameEmployee, lastNameEmployee2);

        System.out.println("Имя последнего сотрудника из employee.xml: " + lastNameEmployee);
        System.out.println("Имя последнего сотрудника из employee2.xml: " + lastNameEmployee2);
    }
}
