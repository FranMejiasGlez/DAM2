
import java.io.BufferedReader;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CrearDOM {

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

                elementoNombreAlumn = ficheroXML.createElement("nombre");
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
            NodeList listaNodos;
            Node alumno;
            listaNodos = ficheroXML.getElementsByTagName("alumno");
            System.out.println("<alumnos>");
            for (int i = 0; i < listaNodos.getLength(); i++) {
                alumno = listaNodos.item(i);
                System.out.println("\t<alumno>");
                if (alumno.getNodeType() == Node.ELEMENT_NODE) {

                    Element elAlumno = (Element) alumno;

                    //Mostrar campos del Elemento <alumno></alumno>

                    String nombre = elAlumno.getElementsByTagName("nombre")
                            .item(0).getTextContent();

                    String idS = elAlumno.getElementsByTagName("id")
                            .item(0)
                            .getTextContent();

                    String notaS = elAlumno.getElementsByTagName("nota")
                            .item(0)
                            .getTextContent();

                    System.out.println("\t\t<nombre>: " + nombre + "</nombre>");
                    System.out.println("\t\t<id>: " + idS + "</id>");
                    System.out.println("\t\t<nota>: " + notaS + "</nota>");
                    System.out.println("\t</alumno>");
                }
            }
            System.out.println("</alumnos>");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error parseando documento");
        } catch (IOException ex) {
            System.out.println("Error de E/S de teclado");
        }
    }
}
