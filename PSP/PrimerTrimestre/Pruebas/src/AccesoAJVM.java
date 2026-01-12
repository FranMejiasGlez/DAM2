
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mejias Gonzalez Francisco
 */
public class AccesoAJVM {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        RuntimeMXBean rmb = ManagementFactory.getRuntimeMXBean();
        System.out.println("PID: ");
        System.out.println(rmb.getName().substring(0, rmb.getName().indexOf("@")));

        System.out.println("EQUIPO: ");
        System.out.println(rmb.getName().substring(rmb.getName().indexOf("@")));

        System.out.println("CLASSPATH: ");
        System.out.println(rmb.getBootClassPath());
        // System.out.println(rmb.getClassPath());

        System.out.println("Lista de argumentos de entrada: ");
        System.out.println(rmb.getInputArguments());

        System.out.println("Lista de propiedades de sistema: ");
        //  System.out.println(rmb.getSystemProperties());

        System.out.println("Propiedad.... --> ");
    }
}
