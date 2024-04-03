package sacovec.olga;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {

    private String room;
    private String lastJobEmployee;
    private String neededJob;

    @Override
    public void startDocument() throws SAXException{
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("tag is " + qName);
        if (qName.equals("office")) {
            room = attributes.getValue("room");
        } else if (qName.equals("employee") && "2".equals(room)) {
            neededJob = attributes.getValue("job");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("employee") && "2".equals(room)) {
            lastJobEmployee = neededJob;
        }
    }

    public String getLastJobEmployee() {
        return lastJobEmployee;
    }
}
