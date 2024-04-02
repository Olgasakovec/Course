package sacovec.olga;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class ClientXmlAuto {
    static final String rootPath = System.getProperty("user.dir");

    public static String getCompanySite()  throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(rootPath + "/src/test/java/sacovec/olga/client.xml"));

        NodeList clientList = doc.getElementsByTagName("client");
        Element secondToLastClient = (Element) clientList.item(clientList.getLength() - 2);
        String companySite = secondToLastClient.getAttribute("companySite");

        return companySite;
    }
}
