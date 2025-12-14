
import facturas.Factura;
import facturas.Facturas;
import facturas.Pelicula;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CrearPeliculas {

    public static Element creaElementoVacio(Document dom, String nombreElemento, Element padre) {
        Element creado;


        creado = dom.createElement(nombreElemento);
        padre.appendChild(creado);
        return creado;
    }

    public static Element creaElementoLleno(Document dom, String nombreElemento, String contenido, Element padre) {
        Element creado;

        creado = dom.createElement(nombreElemento);
        creado.setTextContent(contenido);
        padre.appendChild(creado);
        return creado;
    }

    public static void main(String[] args) {
        try {
            //1.Abrir XML
            XPathFactory xpathF;
            XPath xpath;
            JAXBContext jaxb;
            DocumentBuilderFactory dbf;
            DocumentBuilder docB;
            Document xml;
            Unmarshaller unmarshaller;
            Facturas facturas;
            File salida = new File("Ficheros/Peliculas.xml");
            xpathF = XPathFactory.newInstance();
            xpath = xpathF.newXPath();
            dbf = DocumentBuilderFactory.newInstance();
            docB = dbf.newDocumentBuilder();
            jaxb = JAXBContext.newInstance(facturas.Facturas.class);
            xml = docB.newDocument();
            unmarshaller = jaxb.createUnmarshaller();

            facturas = (Facturas) unmarshaller.unmarshal(new File("Ficheros/XMLSchemaAvanzados05_videoclub.xml"));

            //2.Leer Peliculas y por cada una sacar:Id, Titulo, Duracion y Veces (número de veces alquilada).

            Element raiz = xml.createElement("Peliculas");
            xml.appendChild(raiz);
            InputSource inputSource = null;

            Element padre, idPeli, tituloPeli, duracionPeli, nVeces;
            String expresion;
            HashSet<String> listaPeliculas;
            listaPeliculas = new HashSet<>();

            for (Factura fact : facturas.getFactura()) {

                for (Pelicula pelicula : fact.getDatosFactura().getAlquileres().getPeliculas().getPelicula()) {
                    try {
                        inputSource = new InputSource(new FileInputStream("Ficheros/XMLSchemaAvanzados05_videoclub.xml"));
                    } catch (FileNotFoundException ex) {
                        System.out.println("Fichero xml input no encontrado");
                    }
                    if (!listaPeliculas.contains(pelicula.getTitulo())) {
                        padre = creaElementoVacio(xml, "Pelicula", raiz);
                        idPeli = creaElementoLleno(xml, "Id", pelicula.getIdPelicula(), padre);
                        tituloPeli = creaElementoLleno(xml, "Titulo", pelicula.getTitulo(), padre);
                        duracionPeli = creaElementoLleno(xml, "Duracion", pelicula.getDuracion().toString(), padre);

                        if (inputSource != null) {
                            expresion =
                                    "count(//*[local-name()='pelicula']"
                                    + "[*[local-name()='titulo' and text()='" + pelicula.getTitulo() + "']])";
                            try {
                                nVeces = creaElementoLleno(xml, "Veces", xpath.evaluate(expresion, inputSource), padre);
                            } catch (XPathExpressionException ex) {
                                Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        listaPeliculas.add(pelicula.getTitulo());
                    }
                }
            }

            //3.Guardar en nuevo XML Peliculas.xml
            TransformerFactory transf;
            transf = TransformerFactory.newInstance();
            Transformer trans = transf.newTransformer();

            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            Source source = new DOMSource(xml);
            Result result = new StreamResult(salida);
            try {
                trans.transform(source, result);
            } catch (TransformerException ex) {
                Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JAXBException ex) {
            System.out.println("Error al hacer unmarshall");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error parseando xml");
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error en la configuracion del transformador");
        }
    }
}