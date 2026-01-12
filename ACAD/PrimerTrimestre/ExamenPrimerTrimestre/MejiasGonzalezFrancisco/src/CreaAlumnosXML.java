
import generated.Asignaturas;
import generated.TipoAsignatura;
import generated.TipoPruebas.Prueba;
import java.io.File;
import java.util.List;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CreaAlumnosXML {

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

            JAXBContext jaxb;
            DocumentBuilderFactory dbf;
            DocumentBuilder docB;
            Document xml;
            Unmarshaller unmarshaller;
            Asignaturas asignaturas;
            File salida = new File("Ficheros/alumnos.xml");


            dbf = DocumentBuilderFactory.newInstance();
            docB = dbf.newDocumentBuilder();
            jaxb = JAXBContext.newInstance(generated.Asignaturas.class);
            xml = docB.newDocument();
            unmarshaller = jaxb.createUnmarshaller();

            asignaturas = (Asignaturas) unmarshaller.unmarshal(new File("Ficheros/asignaturas.xml"));

            //2.Leer Asignaturas y por cada alumno sacar nombre, totalPruebas,notaMedia.

            Element raiz = xml.createElement("alumnos");
            xml.appendChild(raiz);

            Element alumno, nombre, totalPruebas, notaMedia;
            Byte pruebasTotales = 0;
            Double media = 0.0;
            int peso;
            List<Prueba> pruebas;



            for (TipoAsignatura asignatura : asignaturas.getAsignatura()) {
                alumno = creaElementoVacio(xml, "alumno", raiz);
                nombre = creaElementoLleno(xml, "nombre", asignatura.getAlumno().getNombre(), alumno);
                pruebasTotales = (byte) asignatura.getPruebas().getPrueba().size();
                totalPruebas = creaElementoLleno(xml, "totalPruebas", pruebasTotales.toString(), alumno);

                pruebas = asignatura.getPruebas().getPrueba();

                for (Prueba prueba : pruebas) {
                    peso = prueba.getPeso();
                    media = media * peso / 100 + prueba.getNota();

                }

                media = media / pruebas.size();
                /* System.out.println(asignatura.getAlumno().getNombre());
                 * System.out.println(media);
                 * System.out.println(pruebas.size());*/
                notaMedia = creaElementoLleno(xml, "notaMedia", media.toString(), alumno);
                media = 0.0;

            }




            //3.Guardar en nuevo XML Peliculas.xml
            TransformerFactory transf;
            transf = TransformerFactory.newInstance();
            Transformer trans;

            trans = transf.newTransformer();


            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            Source source = new DOMSource(xml);
            Result result = new StreamResult(salida);
            try {
                trans.transform(source, result);
            } catch (TransformerException ex) {
                System.out.println("Error en la transformacion de DOM a XML (alumnos.xml)");
            }





        } catch (JAXBException ex) {
            Logger.getLogger(CreaAlumnosXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CreaAlumnosXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(CreaAlumnosXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
