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
 *       &lt;sequence>
 *         &lt;element ref="{facturas}datos_cliente"/>
 *         &lt;element ref="{facturas}datos_factura"/>
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
    "datosCliente",
    "datosFactura"
})
@XmlRootElement(name = "factura")
public class Factura {

    @XmlElement(name = "datos_cliente", required = true)
    protected DatosCliente datosCliente;
    @XmlElement(name = "datos_factura", required = true)
    protected DatosFactura datosFactura;

    /**
     * Obtiene el valor de la propiedad datosCliente.
     * 
     * @return
     *     possible object is
     *     {@link DatosCliente }
     *     
     */
    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    /**
     * Define el valor de la propiedad datosCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosCliente }
     *     
     */
    public void setDatosCliente(DatosCliente value) {
        this.datosCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad datosFactura.
     * 
     * @return
     *     possible object is
     *     {@link DatosFactura }
     *     
     */
    public DatosFactura getDatosFactura() {
        return datosFactura;
    }

    /**
     * Define el valor de la propiedad datosFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosFactura }
     *     
     */
    public void setDatosFactura(DatosFactura value) {
        this.datosFactura = value;
    }

}
