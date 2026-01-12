
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CrearXML2 {
  public static void main(String[] args) {
        try {
            BufferedReader teclado;
            String linea;
            int id = 0;
            float nota = 0;
            boolean esValido;
            DocumentBuilderFactory dbf;
            DocumentBuilder doc;
            Document ficheroXML;
            Node elementoRaiz, elementoAlumno, elementoNombreAlumn, nodoID, nodoNota;
            Text textoElement;

            dbf = DocumentBuilderFactory.newInstance();//Crear fabrica de documentos
            doc = dbf.newDocumentBuilder(); // Instanciar nuevo Constructor de documentos
            ficheroXML = doc.newDocument(); // Instanciar nuevo documento vacio


            elementoRaiz = ficheroXML.createElement("alumnos");
            ficheroXML.appendChild(elementoRaiz);//Agregamos al documento el primer Elemento (raiz)


            teclado = new BufferedReader(new InputStreamReader(System.in));

            //Preguntar por los datos del elemento y agregar 3 veces
            for (int i = 0; i <= 2; i++) {
                elementoAlumno = ficheroXML.createElement("alumno");
                elementoRaiz.appendChild(elementoAlumno);//Agregar al doc el primer elemento

                do {
                    System.out.println("Introduce un Nombre: ");
                    linea = teclado.readLine();
                } while (linea.isEmpty());

                elementoNombreAlumn = ficheroXML.createElement("Nombre");
                textoElement = ficheroXML.createTextNode(linea);
                elementoNombreAlumn.appendChild(textoElement);
                elementoAlumno.appendChild(elementoNombreAlumn);

                do {
                    esValido = true;
                    try {
                        System.out.println("Introduce un id mayor que 0: ");
                        id = Integer.parseInt(teclado.readLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("dato invalido, teclee otro.");
                        esValido = false;
                    }
                } while (esValido == false || id < 0);

                nodoID = ficheroXML.createElement("id");
                textoElement = ficheroXML.createTextNode(Integer.toString(id));
                nodoID.appendChild(textoElement);
                elementoAlumno.appendChild(nodoID);

                do {
                    esValido = true;
                    try {
                        System.out.println("Introduce una nota entre 0 y 10 inclusives: ");
                        nota = Float.parseFloat(teclado.readLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("dato invalido, teclee otro.");
                        esValido = false;
                    }
                } while (esValido == false || nota < 0 || nota > 10);

                nodoNota = ficheroXML.createElement("nota");
                textoElement = ficheroXML.createTextNode(Float.toString(nota));
                nodoNota.appendChild(textoElement);
                elementoAlumno.appendChild(nodoNota);

            }
            //Mostrar el DOM
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //Configuracion de la salida
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(ficheroXML);
            StreamResult resultado = new StreamResult(System.out);//Salida por consola
            transformer.transform(source, resultado);//Transformar source en result

        } catch (ParserConfigurationException ex) {
            System.out.println("Error parseando documento");
        } catch (IOException ex) {
            System.out.println("Error de E/S de teclado");
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error en la configuracion del transformador");
        } catch (TransformerException ex) {
            System.out.println("Error al transformar");
        }
    }
}
