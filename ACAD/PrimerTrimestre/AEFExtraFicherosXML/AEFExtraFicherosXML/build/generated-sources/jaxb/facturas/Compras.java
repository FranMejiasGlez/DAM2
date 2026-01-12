//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.14 a las 09:23:55 PM CET 
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
 *       &lt;choice>
 *         &lt;element ref="{facturas}dvds"/>
 *         &lt;element ref="{facturas}cintas"/>
 *         &lt;element name="dvds_cintas">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{facturas}dvds"/>
 *                   &lt;element ref="{facturas}cintas"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dvds",
    "cintas",
    "dvdsCintas"
})
@XmlRootElement(name = "compras")
public class Compras {

    protected Dvds dvds;
    protected Cintas cintas;
    @XmlElement(name = "dvds_cintas", namespace = "")
    protected Compras.DvdsCintas dvdsCintas;

    /**
     * Obtiene el valor de la propiedad dvds.
     * 
     * @return
     *     possible object is
     *     {@link Dvds }
     *     
     */
    public Dvds getDvds() {
        return dvds;
    }

    /**
     * Define el valor de la propiedad dvds.
     * 
     * @param value
     *     allowed object is
     *     {@link Dvds }
     *     
     */
    public void setDvds(Dvds value) {
        this.dvds = value;
    }

    /**
     * Obtiene el valor de la propiedad cintas.
     * 
     * @return
     *     possible object is
     *     {@link Cintas }
     *     
     */
    public Cintas getCintas() {
        return cintas;
    }

    /**
     * Define el valor de la propiedad cintas.
     * 
     * @param value
     *     allowed object is
     *     {@link Cintas }
     *     
     */
    public void setCintas(Cintas value) {
        this.cintas = value;
    }

    /**
     * Obtiene el valor de la propiedad dvdsCintas.
     * 
     * @return
     *     possible object is
     *     {@link Compras.DvdsCintas }
     *     
     */
    public Compras.DvdsCintas getDvdsCintas() {
        return dvdsCintas;
    }

    /**
     * Define el valor de la propiedad dvdsCintas.
     * 
     * @param value
     *     allowed object is
     *     {@link Compras.DvdsCintas }
     *     
     */
    public void setDvdsCintas(Compras.DvdsCintas value) {
        this.dvdsCintas = value;
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
     *         &lt;element ref="{facturas}dvds"/>
     *         &lt;element ref="{facturas}cintas"/>
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
        "dvds",
        "cintas"
    })
    public static class DvdsCintas {

        @XmlElement(required = true)
        protected Dvds dvds;
        @XmlElement(required = true)
        protected Cintas cintas;

        /**
         * Obtiene el valor de la propiedad dvds.
         * 
         * @return
         *     possible object is
         *     {@link Dvds }
         *     
         */
        public Dvds getDvds() {
            return dvds;
        }

        /**
         * Define el valor de la propiedad dvds.
         * 
         * @param value
         *     allowed object is
         *     {@link Dvds }
         *     
         */
        public void setDvds(Dvds value) {
            this.dvds = value;
        }

        /**
         * Obtiene el valor de la propiedad cintas.
         * 
         * @return
         *     possible object is
         *     {@link Cintas }
         *     
         */
        public Cintas getCintas() {
            return cintas;
        }

        /**
         * Define el valor de la propiedad cintas.
         * 
         * @param value
         *     allowed object is
         *     {@link Cintas }
         *     
         */
        public void setCintas(Cintas value) {
            this.cintas = value;
        }

    }

}
