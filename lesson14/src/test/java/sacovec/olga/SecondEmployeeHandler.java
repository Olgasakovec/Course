package sacovec.olga;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SecondEmployeeHandler extends DefaultHandler {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    private String neededName;

    @Override
    public void startDocument() throws SAXException{
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("tag is " + qName);
        if (qName.equals("employee")) {
            neededName = attributes.getValue("name");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("employee")) {
            String lastNameEmployee = neededName;
        }
    }
}
