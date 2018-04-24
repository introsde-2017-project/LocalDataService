package introsde.project.data.soap.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import introsde.project.data.soap.dao.DatabaseDao;

@Entity  // indicates that this class is an entity to persist in DB
@Table(name="Person") // to whate table must be persisted
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
@XmlRootElement(name="Person")
public class Person implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 @TableGenerator(name = "Person_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Usr_Gen", initialValue = 100)
	 @Id // defines this attributed as the one that identifies the entity 
	 @GeneratedValue(strategy = GenerationType.TABLE, generator = "Person_Gen")
	 @Column(name="idPerson") // maps the following attribute to a column
	 private int idPerson;
	 @Column(name="lastName")
	 private String lastName;
	 @Column(name="firstName")
	 private String firstName;
	 @Column(name="userName")
	 private String userName;
	 @Column(name="password")
	 private String password;
	 @Column(name="birthDate")
	 private String birthDate;
//	 @OneToMany(
//	    		mappedBy="person",
//	    		cascade=CascadeType.ALL,
//	    		fetch=FetchType.EAGER)
	 @ElementCollection
	 private List<FoodType> foodTypes;
//	 @OneToMany(
//	    		mappedBy="person",
//	    		cascade=CascadeType.ALL,
//	    		fetch=FetchType.EAGER)
	 @ElementCollection
	 private List<MovieGen> movieGens;
	 
	 public Person() {
		 foodTypes= new LinkedList<FoodType>();
		 movieGens= new LinkedList<MovieGen>();
	 }

	 public Person(String lastName,
			 String firstName, 
			 String userName, 
			 String password, 
			 String birthDate, 
			 LinkedList<FoodType> fType,
			 LinkedList<MovieGen> mGen
			 ) {
		this.firstName= firstName;
		this.lastName= lastName;
		this.userName= userName;
		this.password= password;
		this.birthDate= birthDate;
		this.foodTypes=fType;
		this.movieGens= mGen;
	}

	public List<MovieGen> getMovieGens() {
			if(this.movieGens==null) 
				this.movieGens= new LinkedList<>();
		    return this.movieGens;
	 }
	 public void setMovieGens(List<MovieGen> types) {
			this.movieGens=types;
			
	 }
	 public List<FoodType> getFoodTypes() {
		 if(this.foodTypes==null) 
			 this.foodTypes= new LinkedList<>();
		 return this.foodTypes;
	 }
	 public void setFoodTypes(List<FoodType> types) {
		 this.foodTypes=types;	
	 }
	 
	 public String getUserName() {
			return userName;
	 }
	 public void setUserName(String userName) {
		this.userName = userName;
	 }

	 public String getPassword() {
		return password;
	 }
	 public void setPassword(String password) {
		this.password = password;
	 }
	 public int getIdPerson() {
		return idPerson;	
	 }
	 public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	 }
	 public String getLastName() {
		return lastName;
	 }
	 public void setLastName(String lastName) {
		this.lastName = lastName;
	 }
	 public String getFirstName() {
		return firstName;
	 }
	 public void setFirstName(String firstName) {
		this.firstName = firstName;
	 }
	 public String getBirthDate() {
		return birthDate;
	 }
	 public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	 }
	 
	 public static Person getPersonById(int PersonId) {
	        EntityManager em = DatabaseDao.instance.createEntityManager();
	        Person p = em.find(Person.class, PersonId);
	        DatabaseDao.instance.closeConnections(em);
	        return p;
	    }
	    
	    public static List<Person> getAll() {
	        EntityManager em = DatabaseDao.instance.createEntityManager();
	        List<Person> list = em.createNamedQuery("Person.findAll", Person.class)
	            .getResultList();
	        DatabaseDao.instance.closeConnections(em);
	        return list;
	    }

	    public static Person savePerson(Person p){
	        EntityManager em = DatabaseDao.instance.createEntityManager();
	        EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        em.persist(p);
	        tx.commit();
	        Person Person = em.find(Person.class, p.getIdPerson());
	        DatabaseDao.instance.closeConnections(em);
	        return Person;
	    } 

	    public static Person updatePerson(Person p) {
	        EntityManager em = DatabaseDao.instance.createEntityManager(); 
	        EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        p=em.merge(p);
	        tx.commit();
	        Person Person = em.find(Person.class, p.getIdPerson());
	        DatabaseDao.instance.closeConnections(em);
	        return Person;
	    }

	    public static void removePerson(Person p) {
	        EntityManager em = DatabaseDao.instance.createEntityManager();
	        EntityTransaction tx = em.getTransaction();
	        tx.begin();
	        p=em.merge(p);
	        em.remove(p);
	        tx.commit();
	        DatabaseDao.instance.closeConnections(em);
	    }

		public static Person getPersonByUserName(String username) {
			for(Person p: Person.getAll()) {
				if(p.getUserName().equalsIgnoreCase(username)) {
					return p;
				}
			}
			return null;
		}

}
