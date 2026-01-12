//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci  n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder  n si se vuelve a compilar el esquema de origen. 
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
 *         &lt;element ref="{facturas}titulo"/>
 *         &lt;element ref="{facturas}formato"/>
 *         &lt;element ref="{facturas}rebobinado" minOccurs="0"/>
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
    "titulo",
    "formato",
    "rebobinado"
})
@XmlRootElement(name = "cinta")
public class Cinta {

    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String formato;
    protected Rebobinado rebobinado;

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad formato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Define el valor de la propiedad formato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormato(String value) {
        this.formato = value;
    }

    /**
     * Obtiene el valor de la propiedad rebobinado.
     * 
     * @return
     *     possible object is
     *     {@link Rebobinado }
     *     
     */
    public Rebobinado getRebobinado() {
        return rebobinado;
    }

    /**
     * Define el valor de la propiedad rebobinado.
     * 
     * @param value
     *     allowed object is
     *     {@link Rebobinado }
     *     
     */
    public void setRebobinado(Rebobinado value) {
        this.rebobinado = value;
    }

}
