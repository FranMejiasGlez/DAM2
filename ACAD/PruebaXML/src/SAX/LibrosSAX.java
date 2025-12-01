/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class LibrosSAX {

    public static void main(String[] args) {
        try {
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            PruebaSAX gestor = new PruebaSAX();
            procesadorXML.setContentHandler(gestor);
            InputSource fileXML =
                    new InputSource("LibrosXML.xml");
            procesadorXML.parse(fileXML);
            gestor.startDocument();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero no encontrado");

        } catch (IOException ex) {
            System.out.println("Error de E/S en fichero");
        } catch (SAXException ex) {
            System.out.println("Error de parseo xml");
        }
    }
}
