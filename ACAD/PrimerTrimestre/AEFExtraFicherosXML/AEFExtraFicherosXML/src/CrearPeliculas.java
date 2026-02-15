
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 *
 * @author Pablo Jimenez Fuentes
 */
public class CrearPeliculas {

    public static org.w3c.dom.Element creaElementoVacio(Document dom, String nombreElemento, org.w3c.dom.Element padre) {
        org.w3c.dom.Element creado;


        creado = dom.createElement(nombreElemento);
        padre.appendChild(creado);
        return creado;
    }

    public static org.w3c.dom.Element creaElementoLleno(Document dom, String nombreElemento, String contenido, org.w3c.dom.Element padre) {
        org.w3c.dom.Element creado;

        creado = dom.createElement(nombreElemento);
        creado.setTextContent(contenido);
        padre.appendChild(creado);
        return creado;
    }

    public static void main(String[] args) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            HashSet<String> peliculasAniadidas = new HashSet<String>();
            Transformer t = tf.newTransformer();
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            DOMSource source;
            StreamResult result;

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document domPelis = (Document) db.newDocument();
            JAXBContext context = JAXBContext.newInstance(facturas.Facturas.class);
            Unmarshaller unmarshall = context.createUnmarshaller();
            Element raizPelis;
            File salida = new File("Peliculas.xml");
            InputSource inputsource;

            facturas.Facturas raiz = (facturas.Facturas) unmarshall.unmarshal(new File("XMLSchemaAvanzados05_videoclub.xml"));
            raizPelis = (Element) domPelis.createElement("peliculas");
            domPelis.appendChild((Node) raizPelis);
            
            for (facturas.Factura fact : raiz.getFactura()) {
                for (facturas.Pelicula peli : fact.getDatosFactura().getAlquileres().getPeliculas().getPelicula()) {
                    if (!peliculasAniadidas.contains(peli.getTitulo())) {
                        inputsource = new InputSource(new FileInputStream(new File("XMLSchemaAvanzados05_videoclub.xml")));
                        Element pelicula = CrearPeliculas.creaElementoVacio(domPelis, "pelicula", raizPelis);
                        pelicula.setAttribute("id", peli.getIdPelicula());
                        Element titulo = CrearPeliculas.creaElementoLleno(domPelis, "titulo", peli.getTitulo(), pelicula);
                        Element duracion = CrearPeliculas.creaElementoLleno(domPelis, "duracion", peli.getDuracion().toString(), pelicula);
                        String consulta = "count(//*[local-name()='pelicula'][*[local-name()='titulo']='" + peli.getTitulo() + "'])";
                        Element nVeces = CrearPeliculas.creaElementoLleno(domPelis, "veces", xpath.evaluate(consulta, inputsource), pelicula);
                        peliculasAniadidas.add(titulo.getTextContent());
                    }

                }
            }
            t.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            source = new DOMSource(domPelis);
            result = new StreamResult(salida);
            t.transform(source, result);
        } catch (JAXBException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (XPathExpressionException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CrearPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
