/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin documento XML");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("\t Principio de elemento: " + localName);
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("\t Fin elemento: " + localName);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Caracteres: " + ch);
        super.characters(ch, start, length);
    }
}
