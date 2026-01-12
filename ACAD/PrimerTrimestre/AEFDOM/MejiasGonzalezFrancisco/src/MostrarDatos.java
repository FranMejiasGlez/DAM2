
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class MostrarDatos {
//Metodo para pasar por valor el elementoPadre y obtener el valor del nodo

    public static String obtenerValorElemento(Element elementoPadre, String nombreEtiqueta) {
        String salida = "";
        NodeList listaNodos;
        listaNodos = elementoPadre.getElementsByTagName(nombreEtiqueta);

        if (listaNodos.getLength() < 0) {
            System.out.println("No hay nodos");
        } else {
            salida = listaNodos.item(0).getTextContent();
        }


        return salida;
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf;
            DocumentBuilder doc;
            Document ficheroXML;
            NodeList listaElementos;

            dbf = DocumentBuilderFactory.newInstance();
            doc = dbf.newDocumentBuilder();
            ficheroXML = doc.parse("empleados.xml");

            listaElementos = ficheroXML.getElementsByTagName("empleado");

            for (int i = 0; i < listaElementos.getLength(); i++) {
                Element empleado = (Element) listaElementos.item(i);


                String apellidos = obtenerValorElemento(empleado, "apellidos");
                String departamento = obtenerValorElemento(empleado, "departamento");


                System.out.println(apellidos + "\t\t" + departamento);
            }
        } catch (ParserConfigurationException ex) {
            System.out.println("Error de parseo en documento;");
        } catch (SAXException ex) {
            System.out.println("Error de SAX");
        } catch (IOException ex) {
            System.out.println("Error de E/S con fichero XML");
        }

    }
}
