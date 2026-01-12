//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci  n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder  n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.14 a las 06:44:01 PM CET 
//


package facturas;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{facturas}genero"/>
 *         &lt;element ref="{facturas}duracion"/>
 *         &lt;element ref="{facturas}actores"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id_pelicula" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="valoracion" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "genero",
    "duracion",
    "actores"
})
@XmlRootElement(name = "pelicula")
public class Pelicula {

    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String genero;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger duracion;
    @XmlElement(required = true)
    protected Actores actores;
    @XmlAttribute(name = "id_pelicula", required = true)
    protected String idPelicula;
    @XmlAttribute(name = "valoracion")
    protected String valoracion;

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
     * Obtiene el valor de la propiedad genero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define el valor de la propiedad genero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenero(String value) {
        this.genero = value;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDuracion(BigInteger value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad actores.
     * 
     * @return
     *     possible object is
     *     {@link Actores }
     *     
     */
    public Actores getActores() {
        return actores;
    }

    /**
     * Define el valor de la propiedad actores.
     * 
     * @param value
     *     allowed object is
     *     {@link Actores }
     *     
     */
    public void setActores(Actores value) {
        this.actores = value;
    }

    /**
     * Obtiene el valor de la propiedad idPelicula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPelicula() {
        return idPelicula;
    }

    /**
     * Define el valor de la propiedad idPelicula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPelicula(String value) {
        this.idPelicula = value;
    }

    /**
     * Obtiene el valor de la propiedad valoracion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoracion() {
        return valoracion;
    }

    /**
     * Define el valor de la propiedad valoracion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoracion(String value) {
        this.valoracion = value;
    }

}
