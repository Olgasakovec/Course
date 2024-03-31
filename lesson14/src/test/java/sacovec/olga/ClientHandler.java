package sacovec.olga;
import com.azul.crs.client.Client;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

/*
        С помощью DOM спарсите client.xml и получите companySite предпоследнего клиента
        Напишите тест, который будет переходит по url из параметра companySite предпоследнего клиента и проверять,
        что заголовок сайта на который был переход имеет значения EPAM | Software Engineering & Product Development Services
        Проверку выполнить через jUnit5.
         */
public class ClientHandler extends DefaultHandler {

    private static String room;
    String companySite;

    public static String getCompanySite() {
        String companySite = null;
        return companySite;
    }

    private List<Client> clientList = new ArrayList<>();
    public List<Client> getClientList(){
        return clientList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        System.out.println("Open tag" + qName);

        if(qName.equals("office")){
            room = attributes.getValue("companySite");
        }

        if(qName.equals("client")) {

            if (room.equals("2")) {
                String name = attributes.getValue("name");
                String id = attributes.getValue("id");
                companySite = attributes.getValue(("companySite")-2);
                Client client = new Client(name, companySite, id);
                clientList.add(client);
            }
        }
    }

    @Override
    public void endElement(String url, String localName, String qName) throws SAXException {
        System.out.println("End tag" + qName);
    }
}
