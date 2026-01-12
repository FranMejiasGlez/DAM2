
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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
import org.w3c.dom.Text;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class CrearEmpleadosXML {

//Cambiar el tipo primitivo segun cantidad de registros del fichero directo
//En el caso de esta actividad, el fichero tiene 10 registros, va bien con byte
    public static String[] leerREmple(byte numRegistro) throws FileNotFoundException, IOException {
        String[] salida = null;
        if (numRegistro >= 0) {
            RandomAccessFile raf = new RandomAccessFile("REmple.dat", "r");
            String departamento, apellidos;
            Integer id;
            Float sueldo;
            long posicion = numRegistro * 78L;

            //Comienza lectura de un registro
            raf.seek(posicion);

            id = raf.readInt(); //Leer Id


            // Leer apellidos (15 caracteres)
            StringBuilder ape = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                ape.append(raf.readChar());
            }
            apellidos = ape.toString().trim();

            // Leer departamento (20 caracteres)
            StringBuilder depart = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                depart.append(raf.readChar());
            }
            departamento = depart.toString().trim();
            sueldo = raf.readFloat();

            //Construir la salida de la funcion y devolver un array
            salida = new String[4];
            salida[0] = id.toString();
            salida[1] = apellidos;
            salida[2] = departamento;
            salida[3] = sueldo.toString();

        }
        return salida;
    }

    public static void main(String[] args) {
        try {
            final byte TAMANIOREMPLE = 10;
            String[] empleado;
            DocumentBuilderFactory dbf;
            DocumentBuilder doc;
            Document ficheroXML;

            Element raiz;
            Text text;

            dbf = DocumentBuilderFactory.newInstance();
            doc = dbf.newDocumentBuilder();

            ficheroXML = doc.newDocument();

            //Crear la raiz del documento empleados
            raiz = ficheroXML.createElement("empleados");
            ficheroXML.appendChild(raiz);
            for (byte i = 0; i < TAMANIOREMPLE; i++) {

                empleado = leerREmple(i);

                if (empleado != null) {
                    //Creamos el elemento actual empleado
                    Element empleEle = ficheroXML.createElement("empleado");


                    //Creamos el primer nodo --> id --> tomamos el texto del array --> append bajo empleado
                    Element empleIdEle = ficheroXML.createElement("id");
                    text = ficheroXML.createTextNode(empleado[0]);
                    empleIdEle.appendChild(text);
                    empleEle.setAttribute("id", text.getTextContent());

                    //Creamos el segundo nodo --> apellido --> tomamos el texto del array --> append bajo empleado
                    Element empleApe = ficheroXML.createElement("apellidos");
                    text = ficheroXML.createTextNode(empleado[1]);
                    empleApe.appendChild(text);
                    empleEle.appendChild(empleApe);

                    //Creamos el tercer nodo --> departamento --> tomamos el texto del array --> append bajo empleado
                    Element empleNombre = ficheroXML.createElement("departamento");
                    text = ficheroXML.createTextNode(empleado[2]);
                    empleNombre.appendChild(text);
                    empleEle.appendChild(empleNombre);

                    //Creamos el cuarto nodo --> sueldo --> tomamos el texto del array --> append bajo empleado
                    Element empleSueldo = ficheroXML.createElement("salario");
                    text = ficheroXML.createTextNode(empleado[3]);
                    empleSueldo.appendChild(text);
                    empleEle.appendChild(empleSueldo);


                    //Agregar empleado a la raiz
                    raiz.appendChild(empleEle);
                }
            }
            //Transformar y guardar en XML
            TransformerFactory tf;
            Transformer transformar;

            //Instanciar factory y transformer
            tf = TransformerFactory.newInstance();
            transformar = tf.newTransformer();

            //Configurar transformador
            transformar.setOutputProperty(OutputKeys.INDENT, "yes");
            transformar.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformar.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            //Transformar source en result
            Source dat = new DOMSource(ficheroXML);
            Result xml = new StreamResult(new File("empleados.xml"));

            transformar.transform(dat, xml);
            System.out.println("Fichero REmple.dat transformado en emplados.xml ");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error de parseo de documento XML");
        } catch (TransformerConfigurationException ex) {
            System.out.println("Error en la configuracion del transformador");
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero REmple.dat no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de entrada salida en fichero REmple.dat");
        } catch (TransformerException ex) {
            System.out.println("Error al transformar documento");
        }

    }
}
