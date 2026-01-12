
import java.io.File;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class TransformarXML {

    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();

            Source xslt = new StreamSource(new File("empleados.xsl"));//Damos el source xsl
            Transformer transformar = factory.newTransformer(xslt);
            Source xml = new StreamSource(new File("empleados.xml")); //Damos el source xml
            Result html = new StreamResult(new File("empleados.html")); //Damos el result html

            transformar.transform(xml, html);
            System.out.println("html generado");

        } catch (TransformerConfigurationException ex) {
            System.out.println("Error al configurar la transformacion");
        } catch (TransformerException ex) {
            System.out.println("Error en la tranformacion");
        }
    }
}
