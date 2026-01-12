
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tipoPruebaDAO.Prueba;
import tipoPruebaDAO.TipoPruebaDAO;
import seisPruebasDAO.SeisPruebasDAO;

public class Ejercicio5 {

    private static void extraerPrimerosTres(TipoPruebaDAO dao, List<Prueba> destino) throws IOException {
        int encontrados = 0;

        while (!dao.isFf() && encontrados < 3) {
            Prueba p = dao.leer();


            if (p != null && p.getNumeroPrueba() > 0) {
                destino.add(p);
                encontrados++;
            }
        }
    }

    public static void main(String[] args) {

        List<Prueba> buffer = new ArrayList<>();

        TipoPruebaDAO daoOp = null;
        TipoPruebaDAO daoOb = null;
        DataOutputStream dos = null;

        try {
            daoOp = new TipoPruebaDAO("Ficheros/opcional.dat", "r");
            daoOb = new TipoPruebaDAO("Ficheros/obligatorio.dat", "r");

            extraerPrimerosTres(daoOp, buffer);

            extraerPrimerosTres(daoOb, buffer);

            Collections.sort(buffer, new Comparator<Prueba>() {
                @Override
                public int compare(Prueba p1, Prueba p2) {
                    return Byte.compare(p1.getNumeroPrueba(), p2.getNumeroPrueba());
                }
            });

            dos = new DataOutputStream(new FileOutputStream("Ficheros/seisPruebas.dat"));

            for (Prueba p : buffer) {
                SeisPruebasDAO.escribir(dos, p);

            }

        } catch (IOException e) {
            System.out.println("Error de E/S");
        } finally {
            try {
                if (daoOp != null) {
                    daoOp.cerrar();
                }
                if (daoOb != null) {
                    daoOb.cerrar();
                }
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar recursos.");
            }
        }
    }
}