//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.15 a las 09:04:10 PM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TipoAsignatura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TipoAsignatura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alumno" type="{}TipoAlumno"/>
 *         &lt;element name="fechaAlta" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="pruebas" type="{}TipoPruebas"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoAsignatura", propOrder = {
    "alumno",
    "fechaAlta",
    "pruebas"
})
public class TipoAsignatura {

    @XmlElement(required = true)
    protected TipoAlumno alumno;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaAlta;
    @XmlElement(required = true)
    protected TipoPruebas pruebas;

    /**
     * Obtiene el valor de la propiedad alumno.
     * 
     * @return
     *     possible object is
     *     {@link TipoAlumno }
     *     
     */
    public TipoAlumno getAlumno() {
        return alumno;
    }

    /**
     * Define el valor de la propiedad alumno.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoAlumno }
     *     
     */
    public void setAlumno(TipoAlumno value) {
        this.alumno = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAlta(XMLGregorianCalendar value) {
        this.fechaAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad pruebas.
     * 
     * @return
     *     possible object is
     *     {@link TipoPruebas }
     *     
     */
    public TipoPruebas getPruebas() {
        return pruebas;
    }

    /**
     * Define el valor de la propiedad pruebas.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoPruebas }
     *     
     */
    public void setPruebas(TipoPruebas value) {
        this.pruebas = value;
    }

}
