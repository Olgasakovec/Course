package sacovec.olga;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ClientXmlAuto {
    static final String rootPath = System.getProperty("user.dir");

    @Test
    void example1() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File file = new File(rootPath + "src/test/java/client.xml");

        ClientHandler handler = new ClientHandler();

        parser.parse(file, handler);

        System.out.println(handler.getClientList());
    }
}
