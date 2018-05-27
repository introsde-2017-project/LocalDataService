package introsde.project.data.local.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="food_Type")
public enum FoodType implements Serializable {
	Indian("Indian"),
	Italian("Italian"),
	Chinese("Chinese"),
	Thai("Thai"),
	Mexican("Mexican");
	
	
	private String name;
//	@ManyToOne
//	@JoinColumn(name="personId",referencedColumnName="personId")
//	private Person person;
//	
//	@XmlTransient
//	public Person getPerson() {
//		return person;
//	}
//
//	public void setPerson(Person person) {
//		this.person = person;
//	}
	
	FoodType(String name) {
		name=this.name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	 public String toString() {
	    return name;
	 }
	
	public static List<FoodType> getAll() {
        return Arrays.asList(FoodType.values());
	}
	
	public static FoodType fromString(String text) {
	    for (FoodType b : FoodType.values()) {
	      if (b.name.equalsIgnoreCase(text)) {
	        return b;
	      }
	    }
	    return null;
	  }
}

