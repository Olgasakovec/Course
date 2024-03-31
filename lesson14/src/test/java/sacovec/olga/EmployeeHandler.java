package sacovec.olga;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeHandler extends DefaultHandler {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private String room;
    private String lastJobEmployee;
    private String lastNameEmployee;
    private String lastNameEmployee2;
    private String neededJob;


    @Override
    public void startDocument() throws SAXException{
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("tag is " + qName);
        if (qName.equals("office")) {
            room = attributes.getValue("room");
        } else if (qName.equals("employee") && "2".equals(room)) {
            neededJob = attributes.getValue("job");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("employee") && "2".equals(room)) {
            lastJobEmployee = neededJob;
        }
    }

    public String getLastJobEmployee() {
        return lastJobEmployee;
    }

    public String getLastNameEmployee() {
        return lastNameEmployee;
    }

    public String getLastNameEmployee2() {
        return lastNameEmployee2;
    }
}
