package introsde.project.data.soap.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="movie_Gen")
public enum MovieGen implements Serializable {
	Drama("Drama"),
	Comedy("Comedy"),
	Romance("Romance"),
	Action("Action"),
	Adventure("Adventure"),
	Thriller("Thriller"),
	Fiction("Fiction"),
	Animation("Animation"),
	Horror("Horror");
	
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
	
	MovieGen(String name) {
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
	
	public static List<MovieGen> getAll() {
        return Arrays.asList(MovieGen.values());
	}
}
