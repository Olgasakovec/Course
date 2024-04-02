package sacovec.olga;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static sacovec.olga.ClientXmlAuto.rootPath;

public class EmployeeHandlerTest {

    @Test
    public void testLastJobEmployee() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File file = new File(rootPath + "/src/test/java/sacovec/olga/employee.xml");
        EmployeeHandler handler = new EmployeeHandler();
        parser.parse(file,handler);
        System.out.println(handler.getLastJobEmployee());
        String lastJobEmployee = handler.getLastJobEmployee();
        assertEquals("Senior", lastJobEmployee);
    }
}
