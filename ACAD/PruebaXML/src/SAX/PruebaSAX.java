package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class PruebaSAX extends DefaultHandler {

    public PruebaSAX() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienzo documento XML");

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin documento XML");

    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {

        System.out.println("\t Principio de elemento: " + localName
                + "\n");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("\t Fin elemento: " + localName + "\n");

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String cadena = new String(ch, start, length);
        if (!cadena.trim().isEmpty()) {
            System.out.println("\t Caracteres: " + cadena + "\n");
        }

    }
}
