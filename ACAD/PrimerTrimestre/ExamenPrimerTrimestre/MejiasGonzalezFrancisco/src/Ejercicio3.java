
import generated.Asignaturas;
import generated.TipoAsignatura;
import generated.TipoPruebas.Prueba;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
import tipoPruebaDAO.TipoPruebaDAO;

/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        try {
            TipoPruebaDAO daoFichOb = null;
            TipoPruebaDAO daoFichOp = null;

            XPathFactory xpathF;
            XPath xpath;

            JAXBContext jaxb;
            Unmarshaller unmarshaller;
            Asignaturas asignaturas;

            xpathF = XPathFactory.newInstance();
            xpath = xpathF.newXPath();

            jaxb = JAXBContext.newInstance(generated.Asignaturas.class);

            unmarshaller = jaxb.createUnmarshaller();

            asignaturas = (Asignaturas) unmarshaller.unmarshal(new File("Ficheros/asignaturas.xml"));

            daoFichOb = new TipoPruebaDAO("Ficheros/obligatorio.dat", "w");

            daoFichOp = new TipoPruebaDAO("Ficheros/opcional.dat", "w");

            String expresion;
            tipoPruebaDAO.Prueba nuevaPrueba;

            for (TipoAsignatura tAsignatura : asignaturas.getAsignatura()) {

                for (Prueba prueba : tAsignatura.getPruebas().getPrueba()) {
                    expresion = "count(//prueba[@numero=" + prueba.getNumero() + "])";
                   // System.out.println(prueba.getNumero());
                    //System.out.println(prueba.getTipo());
                    InputSource input = new InputSource(new FileInputStream("Ficheros/asignaturas.xml"));

                    nuevaPrueba = new tipoPruebaDAO.Prueba(Byte.parseByte(prueba.getNumero().toString()),
                            prueba.getNombrePrueba(), Short.parseShort(xpath.evaluate(expresion, input)));

                    if (prueba.getTipo().equalsIgnoreCase("op")) {

                        daoFichOp.escribir(nuevaPrueba,
                                prueba.getNumero().longValue());

                    } else {

                        daoFichOb.escribir(nuevaPrueba,
                                Long.parseLong(prueba.getNumero().toString()));

                    }
                }
            }

        } catch (JAXBException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
