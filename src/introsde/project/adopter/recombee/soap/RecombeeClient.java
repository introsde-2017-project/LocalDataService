
package introsde.project.adopter.recombee.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recombeeClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recombeeClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultProtocol" type="{http://soap.recombee.adopter.project.introsde/}networkApplicationProtocol" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recombeeClient", propOrder = {
    "defaultProtocol"
})
public class RecombeeClient {

    @XmlSchemaType(name = "string")
    protected NetworkApplicationProtocol defaultProtocol;

    /**
     * Gets the value of the defaultProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkApplicationProtocol }
     *     
     */
    public NetworkApplicationProtocol getDefaultProtocol() {
        return defaultProtocol;
    }

    /**
     * Sets the value of the defaultProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkApplicationProtocol }
     *     
     */
    public void setDefaultProtocol(NetworkApplicationProtocol value) {
        this.defaultProtocol = value;
    }

}
