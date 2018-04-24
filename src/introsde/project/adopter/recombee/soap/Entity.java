
package introsde.project.adopter.recombee.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for entity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="entity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://soap.recombee.adopter.project.introsde/}recombeeBinding">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entity")
@XmlSeeAlso({
    Item.class,
    User.class
})
public abstract class Entity
    extends RecombeeBinding
{


}
