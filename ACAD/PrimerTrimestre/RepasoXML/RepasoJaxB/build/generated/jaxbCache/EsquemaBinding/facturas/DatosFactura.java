//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.14 a las 06:44:01 PM CET 
//


package facturas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{facturas}resguardo"/>
 *         &lt;choice>
 *           &lt;element ref="{facturas}alquileres"/>
 *           &lt;element ref="{facturas}compras"/>
 *           &lt;element name="alquileres_compras">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element ref="{facturas}alquileres"/>
 *                     &lt;element ref="{facturas}compras"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resguardo",
    "alquileres",
    "compras",
    "alquileresCompras"
})
@XmlRootElement(name = "datos_factura")
public class DatosFactura {

    @XmlElement(required = true)
    protected Resguardo resguardo;
    protected Alquileres alquileres;
    protected Compras compras;
    @XmlElement(name = "alquileres_compras", namespace = "")
    protected DatosFactura.AlquileresCompras alquileresCompras;

    /**
     * Obtiene el valor de la propiedad resguardo.
     * 
     * @return
     *     possible object is
     *     {@link Resguardo }
     *     
     */
    public Resguardo getResguardo() {
        return resguardo;
    }

    /**
     * Define el valor de la propiedad resguardo.
     * 
     * @param value
     *     allowed object is
     *     {@link Resguardo }
     *     
     */
    public void setResguardo(Resguardo value) {
        this.resguardo = value;
    }

    /**
     * Obtiene el valor de la propiedad alquileres.
     * 
     * @return
     *     possible object is
     *     {@link Alquileres }
     *     
     */
    public Alquileres getAlquileres() {
        return alquileres;
    }

    /**
     * Define el valor de la propiedad alquileres.
     * 
     * @param value
     *     allowed object is
     *     {@link Alquileres }
     *     
     */
    public void setAlquileres(Alquileres value) {
        this.alquileres = value;
    }

    /**
     * Obtiene el valor de la propiedad compras.
     * 
     * @return
     *     possible object is
     *     {@link Compras }
     *     
     */
    public Compras getCompras() {
        return compras;
    }

    /**
     * Define el valor de la propiedad compras.
     * 
     * @param value
     *     allowed object is
     *     {@link Compras }
     *     
     */
    public void setCompras(Compras value) {
        this.compras = value;
    }

    /**
     * Obtiene el valor de la propiedad alquileresCompras.
     * 
     * @return
     *     possible object is
     *     {@link DatosFactura.AlquileresCompras }
     *     
     */
    public DatosFactura.AlquileresCompras getAlquileresCompras() {
        return alquileresCompras;
    }

    /**
     * Define el valor de la propiedad alquileresCompras.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosFactura.AlquileresCompras }
     *     
     */
    public void setAlquileresCompras(DatosFactura.AlquileresCompras value) {
        this.alquileresCompras = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{facturas}alquileres"/>
     *         &lt;element ref="{facturas}compras"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "alquileres",
        "compras"
    })
    public static class AlquileresCompras {

        @XmlElement(required = true)
        protected Alquileres alquileres;
        @XmlElement(required = true)
        protected Compras compras;

        /**
         * Obtiene el valor de la propiedad alquileres.
         * 
         * @return
         *     possible object is
         *     {@link Alquileres }
         *     
         */
        public Alquileres getAlquileres() {
            return alquileres;
        }

        /**
         * Define el valor de la propiedad alquileres.
         * 
         * @param value
         *     allowed object is
         *     {@link Alquileres }
         *     
         */
        public void setAlquileres(Alquileres value) {
            this.alquileres = value;
        }

        /**
         * Obtiene el valor de la propiedad compras.
         * 
         * @return
         *     possible object is
         *     {@link Compras }
         *     
         */
        public Compras getCompras() {
            return compras;
        }

        /**
         * Define el valor de la propiedad compras.
         * 
         * @param value
         *     allowed object is
         *     {@link Compras }
         *     
         */
        public void setCompras(Compras value) {
            this.compras = value;
        }

    }

}
