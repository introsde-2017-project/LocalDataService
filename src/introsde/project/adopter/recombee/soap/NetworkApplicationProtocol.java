
package introsde.project.adopter.recombee.soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for networkApplicationProtocol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="networkApplicationProtocol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HTTP"/>
 *     &lt;enumeration value="HTTPS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "networkApplicationProtocol")
@XmlEnum
public enum NetworkApplicationProtocol {

    HTTP,
    HTTPS;

    public String value() {
        return name();
    }

    public static NetworkApplicationProtocol fromValue(String v) {
        return valueOf(v);
    }

}
