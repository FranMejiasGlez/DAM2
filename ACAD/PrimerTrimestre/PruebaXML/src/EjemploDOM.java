
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class EjemploDOM {

    Document doc; //Objeto Document que almacena el DOM del XML seleccionado

    public int abrir_XML_DOM(File fichero) {
        int valor;
        DocumentBuilderFactory builder;
        DocumentBuilder document;
        builder = DocumentBuilderFactory.newInstance();
        builder.setIgnoringComments(true);
        builder.setIgnoringElementContentWhitespace(true);
        try {
            document = builder.newDocumentBuilder();
            this.doc = document.parse(fichero);
            valor = 1;

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            valor = 0;
        }

        return valor;
    }

    public String recorrerDOMyMostrar() {
        String arbol = "";
        Node raiz;
        NodeList listaNodos;
        String[] datosLibro;

        raiz = doc.getDocumentElement();
        arbol = "Elemento raíz: " + raiz.getNodeName() + "\n";//Muestro la raiz
        System.out.println(arbol);
        arbol = "";

        listaNodos = doc.getElementsByTagName("Libro");
        System.out.println("=====================");
        System.out.println("Lista de Libros");
        System.out.println("=====================");

        for (int i = 0; i < listaNodos.getLength(); i++) {
            Node nodo = listaNodos.item(i);
            datosLibro = procesarLibro(nodo); // Retorna [título, autor, año]
            arbol = arbol + "Titulo: " + datosLibro[0]
                    + "\nAutor: " + datosLibro[1]
                    + "\nAño: " + datosLibro[2] + "\n" + "\n";
        }

        return arbol;
    }

    protected String[] procesarLibro(Node n) {
        String[] infoLibro = new String[3];
        Element elemento = (Element) n;

        NodeList titulos = elemento.getElementsByTagName("Titulo");
        NodeList autores = elemento.getElementsByTagName("Autor");
        String ano = elemento.getAttribute("publicado_en");

        infoLibro[0] = titulos.item(0).getTextContent();//Titulo
        infoLibro[1] = autores.item(0).getTextContent();//Autor
        infoLibro[2] = ano;//Anno

        return infoLibro;
    }

    public int aniadirDOM(String titulo, String autor, String anno) {
        try {
            Element elementoTitulo, elementoAutor, elementoNuevoLibro;
            Text textoTitulo, textoAutor;
            elementoNuevoLibro = doc.createElement("Libro");// Crear nuevo nodo Libro
            elementoTitulo = doc.createElement("Titulo");//Crear nuevo nodo Titulo
            elementoAutor = doc.createElement("Autor");//Crear nuevo nodo Autor

            textoTitulo = doc.createTextNode(titulo);//Crear texto Titulo
            textoAutor = doc.createTextNode(autor);//Crear texto Autor
            elementoNuevoLibro.setAttribute("publicado_en", anno);//Agregar atributo de anno

            elementoTitulo.appendChild(textoTitulo); // Crear el titulo del nodo Libro
            elementoAutor.appendChild(textoAutor);//Crear el autor del nodo Libro

            //Asignar los nodos al nodo Padre Libro

            elementoNuevoLibro.appendChild(elementoTitulo);
            elementoNuevoLibro.appendChild(elementoAutor);

            Element raiz = doc.getDocumentElement(); // Obtener <Libros>
            raiz.appendChild(elementoNuevoLibro); // Agregar el nuevo Libro a <Libros>
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        // 1. Crear instancia
        EjemploDOM ejemplo = new EjemploDOM();

        // 2. Abrir XML
        File fichero = new File("LibrosXML.xml");
        int resultado = ejemplo.abrir_XML_DOM(fichero);

        if (resultado == -1) {
            System.out.println("Error al abrir XML");
            return;
        }

        // 3. Mostrar contenido original
        System.out.println("=== CONTENIDO ORIGINAL ===");
        System.out.println(ejemplo.recorrerDOMyMostrar());

        // 4. Añadir nuevo libro
        ejemplo.aniadirDOM("El Corredor del Laberinto", "Fran Mejias", "2025");

        // 5. Mostrar contenido actualizado
        System.out.println("\n=== CONTENIDO ACTUALIZADO ===");
        System.out.println(ejemplo.recorrerDOMyMostrar());
    }
}
