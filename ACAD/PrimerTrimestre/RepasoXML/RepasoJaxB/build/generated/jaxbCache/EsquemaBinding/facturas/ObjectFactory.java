//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.14 a las 06:44:01 PM CET 
//


package facturas;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the facturas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FechaSalidaMercado_QNAME = new QName("facturas", "fecha_salida_mercado");
    private final static QName _Formato_QNAME = new QName("facturas", "formato");
    private final static QName _Dni_QNAME = new QName("facturas", "dni");
    private final static QName _Duracion_QNAME = new QName("facturas", "duracion");
    private final static QName _Tfno_QNAME = new QName("facturas", "tfno");
    private final static QName _Nombre_QNAME = new QName("facturas", "nombre");
    private final static QName _Apellido_QNAME = new QName("facturas", "apellido");
    private final static QName _FormaPago_QNAME = new QName("facturas", "forma_pago");
    private final static QName _Genero_QNAME = new QName("facturas", "genero");
    private final static QName _Titulo_QNAME = new QName("facturas", "titulo");
    private final static QName _Fecha_QNAME = new QName("facturas", "fecha");
    private final static QName _ImporteTotal_QNAME = new QName("facturas", "importe_total");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: facturas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Compras }
     * 
     */
    public Compras createCompras() {
        return new Compras();
    }

    /**
     * Create an instance of {@link DatosFactura }
     * 
     */
    public DatosFactura createDatosFactura() {
        return new DatosFactura();
    }

    /**
     * Create an instance of {@link Peliculas }
     * 
     */
    public Peliculas createPeliculas() {
        return new Peliculas();
    }

    /**
     * Create an instance of {@link Pelicula }
     * 
     */
    public Pelicula createPelicula() {
        return new Pelicula();
    }

    /**
     * Create an instance of {@link Actores }
     * 
     */
    public Actores createActores() {
        return new Actores();
    }

    /**
     * Create an instance of {@link Actor }
     * 
     */
    public Actor createActor() {
        return new Actor();
    }

    /**
     * Create an instance of {@link Cintas }
     * 
     */
    public Cintas createCintas() {
        return new Cintas();
    }

    /**
     * Create an instance of {@link Cinta }
     * 
     */
    public Cinta createCinta() {
        return new Cinta();
    }

    /**
     * Create an instance of {@link Rebobinado }
     * 
     */
    public Rebobinado createRebobinado() {
        return new Rebobinado();
    }

    /**
     * Create an instance of {@link Alquileres }
     * 
     */
    public Alquileres createAlquileres() {
        return new Alquileres();
    }

    /**
     * Create an instance of {@link Factura }
     * 
     */
    public Factura createFactura() {
        return new Factura();
    }

    /**
     * Create an instance of {@link DatosCliente }
     * 
     */
    public DatosCliente createDatosCliente() {
        return new DatosCliente();
    }

    /**
     * Create an instance of {@link Resguardo }
     * 
     */
    public Resguardo createResguardo() {
        return new Resguardo();
    }

    /**
     * Create an instance of {@link Dvds }
     * 
     */
    public Dvds createDvds() {
        return new Dvds();
    }

    /**
     * Create an instance of {@link Dvd }
     * 
     */
    public Dvd createDvd() {
        return new Dvd();
    }

    /**
     * Create an instance of {@link Extras }
     * 
     */
    public Extras createExtras() {
        return new Extras();
    }

    /**
     * Create an instance of {@link Compras.DvdsCintas }
     * 
     */
    public Compras.DvdsCintas createComprasDvdsCintas() {
        return new Compras.DvdsCintas();
    }

    /**
     * Create an instance of {@link DatosFactura.AlquileresCompras }
     * 
     */
    public DatosFactura.AlquileresCompras createDatosFacturaAlquileresCompras() {
        return new DatosFactura.AlquileresCompras();
    }

    /**
     * Create an instance of {@link Facturas }
     * 
     */
    public Facturas createFacturas() {
        return new Facturas();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "fecha_salida_mercado")
    public JAXBElement<XMLGregorianCalendar> createFechaSalidaMercado(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FechaSalidaMercado_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "formato")
    public JAXBElement<String> createFormato(String value) {
        return new JAXBElement<String>(_Formato_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "dni")
    public JAXBElement<String> createDni(String value) {
        return new JAXBElement<String>(_Dni_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "duracion")
    public JAXBElement<BigInteger> createDuracion(BigInteger value) {
        return new JAXBElement<BigInteger>(_Duracion_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "tfno")
    public JAXBElement<String> createTfno(String value) {
        return new JAXBElement<String>(_Tfno_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "nombre")
    public JAXBElement<String> createNombre(String value) {
        return new JAXBElement<String>(_Nombre_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "apellido")
    public JAXBElement<String> createApellido(String value) {
        return new JAXBElement<String>(_Apellido_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "forma_pago")
    public JAXBElement<String> createFormaPago(String value) {
        return new JAXBElement<String>(_FormaPago_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "genero")
    public JAXBElement<String> createGenero(String value) {
        return new JAXBElement<String>(_Genero_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "titulo")
    public JAXBElement<String> createTitulo(String value) {
        return new JAXBElement<String>(_Titulo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "fecha")
    public JAXBElement<XMLGregorianCalendar> createFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Fecha_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "facturas", name = "importe_total")
    public JAXBElement<Float> createImporteTotal(Float value) {
        return new JAXBElement<Float>(_ImporteTotal_QNAME, Float.class, null, value);
    }

}
