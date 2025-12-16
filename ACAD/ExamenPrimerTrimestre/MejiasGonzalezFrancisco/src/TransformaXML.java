
import java.io.File;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class TransformaXML {

    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();

            Source xslt = new StreamSource(new File("Ficheros/alumnos.xsl"));//Damos el source xsl
            Transformer transformar = factory.newTransformer(xslt);
            Source xml = new StreamSource(new File("Ficheros/alumnos.xml")); //Damos el source xml
            Result html = new StreamResult(new File("Ficheros/evaluacion.html")); // Damos el result html

            transformar.transform(xml, html);
            System.out.println("Html generado en Ficheros/");

        } catch (TransformerConfigurationException ex) {
            System.out.println("Error al configurar la transformacion");
        } catch (TransformerException ex) {
            System.out.println("Error en la tranformacion");
        }
    }
}
