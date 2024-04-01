package sacovec.olga;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SecondEmployeeHandler extends DefaultHandler {

    private String neededName;
    private String lastNameEmployee;

    @Override
    public void startDocument() throws SAXException{
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("tag is " + qName);
        if (qName.equals("employee")) {
            neededName = attributes.getValue("name");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("employee")) {
            lastNameEmployee = neededName;
        }
    }

    public String getLastNameEmployee() {
        return lastNameEmployee;
    }
}
