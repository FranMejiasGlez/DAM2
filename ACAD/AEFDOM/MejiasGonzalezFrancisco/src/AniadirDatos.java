
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class AniadirDatos {

    public static void main(String[] args) {
        try {
            int ultimoID;
            BufferedReader teclado;
            String apellidos, departamento;
            boolean esValido;
            Float salario = 0F;
            DocumentBuilderFactory dbf;
            DocumentBuilder doc;
            Document ficheroXML;
            NodeList listaEmpleados;
            Text texto;
            Element nuevoEmple, raiz, apell, depart, salar, ultimoEmple;

            dbf = DocumentBuilderFactory.newInstance();
            doc = dbf.newDocumentBuilder();
            ficheroXML = doc.parse("empleados.xml");
            teclado = new BufferedReader(new InputStreamReader(System.in));

            //Sacar el id del ultimo empleadom del fichero xml
            listaEmpleados = ficheroXML.getElementsByTagName("empleado");
            ultimoEmple = (Element) listaEmpleados.item(listaEmpleados
                    .getLength() - 1);

            ultimoID = Integer.parseInt(ultimoEmple.getAttribute("id"));

            // Obtener la raíz del documento
            raiz = ficheroXML.getDocumentElement();

            for (int i = 1; i < 3; i++) {


                do {
                    System.out.println("Introduce apellidos: ");
                    apellidos = teclado.readLine();
                } while (apellidos.isEmpty());

                do {
                    System.out.println("Introduce departamento: ");
                    departamento = teclado.readLine();
                } while (departamento.isEmpty());

                do {
                    esValido = true;
                    try {
                        System.out.println("Introduce salario: ");
                        salario = Float.parseFloat(teclado.readLine());
                    } catch (NumberFormatException nfe) {
                        System.out.println("dato invalido, teclee otro.");
                        esValido = false;
                    }

                } while (esValido == false);

                //Construir nuevo empleado

                nuevoEmple = ficheroXML.createElement("empleado");
                nuevoEmple.setAttribute("id", Integer.toString(ultimoID + 1));
                ultimoID++;
                
                apell = ficheroXML.createElement("apellidos");
                texto = ficheroXML.createTextNode(apellidos);
                apell.appendChild(texto);
                nuevoEmple.appendChild(apell);

                depart = ficheroXML.createElement("departamento");
                texto = ficheroXML.createTextNode(departamento);
                depart.appendChild(texto);
                nuevoEmple.appendChild(depart);

                salar = ficheroXML.createElement("salario");
                texto = ficheroXML.createTextNode(Float.toString(salario));
                salar.appendChild(texto);
                nuevoEmple.appendChild(salar);


                raiz.appendChild(nuevoEmple);
            }
            //Guardar los datos del DOM en archivo empleados.xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource dom = new DOMSource(ficheroXML);
            Result xml = new StreamResult(new File("empleados.xml"));

            transformer.transform(dom, xml);

        } catch (ParserConfigurationException ex) {
            System.out.println("Error de configuracion de parseo");
        } catch (SAXException ex) {
            System.out.println("Error de SAX");
        } catch (IOException ex) {
            System.out.println("Error de E/S en fichero xml");
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error de configuracion de transformacion");
        } catch (TransformerException ex) {
            System.out.println("Error en transformacion");
        }
    }
}
