//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantacin de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perdern si se vuelve a compilar el esquema de origen. 
// Generado el: AM.12.15 a las 09:01:15 AM CET 
//
package generated;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para TipoPruebas complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera
 * que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="TipoPruebas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prueba" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nombrePrueba">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="nota">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                         &lt;minInclusive value="1"/>
 *                         &lt;maxExclusive value="10"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="peso">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="1"/>
 *                         &lt;maxExclusive value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tipo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="op"/>
 *                         &lt;enumeration value="ob"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="numero" type="{}TipoCodigo" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoPruebas", propOrder = {
    "prueba"
})
public class TipoPruebas {

    @XmlElement(required = true)
    protected List<TipoPruebas.Prueba> prueba;

    /**
     * Gets the value of the prueba property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the prueba property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrueba().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoPruebas.Prueba }
     *
     *
     */
    public List<TipoPruebas.Prueba> getPrueba() {
        if (prueba == null) {
            prueba = new ArrayList<TipoPruebas.Prueba>();
        }
        return this.prueba;
    }

    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se
     * espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nombrePrueba">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="nota">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *               &lt;minInclusive value="1"/>
     *               &lt;maxExclusive value="10"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="peso">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="1"/>
     *               &lt;maxExclusive value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="tipo">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="op"/>
     *               &lt;enumeration value="ob"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="numero" type="{}TipoCodigo" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nombrePrueba",
        "nota",
        "peso",
        "tipo"
    })
    public static class Prueba {

        @XmlElement(required = true)
        protected String nombrePrueba;
        protected double nota;
        protected int peso;
        @XmlElement(required = true)
        protected String tipo;
        @XmlAttribute(name = "numero")
        protected BigInteger numero;

        /**
         * Obtiene el valor de la propiedad nombrePrueba.
         *
         * @return possible object is {@link String }
         *
         */
        public String getNombrePrueba() {
            return nombrePrueba;
        }

        /**
         * Define el valor de la propiedad nombrePrueba.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setNombrePrueba(String value) {
            this.nombrePrueba = value;
        }

        /**
         * Obtiene el valor de la propiedad nota.
         *
         */
        public double getNota() {
            return nota;
        }

        /**
         * Define el valor de la propiedad nota.
         *
         */
        public void setNota(double value) {
            this.nota = value;
        }

        /**
         * Obtiene el valor de la propiedad peso.
         *
         */
        public int getPeso() {
            return peso;
        }

        /**
         * Define el valor de la propiedad peso.
         *
         */
        public void setPeso(int value) {
            this.peso = value;
        }

        /**
         * Obtiene el valor de la propiedad tipo.
         *
         * @return possible object is {@link String }
         *
         */
        public String getTipo() {
            return tipo;
        }

        /**
         * Define el valor de la propiedad tipo.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setTipo(String value) {
            this.tipo = value;
        }

        /**
         * Obtiene el valor de la propiedad numero.
         *
         * @return possible object is {@link BigInteger }
         *
         */
        public BigInteger getNumero() {
            return numero;
        }

        /**
         * Define el valor de la propiedad numero.
         *
         * @param value allowed object is {@link BigInteger }
         *
         */
        public void setNumero(BigInteger value) {
            this.numero = value;
        }
    }
}
