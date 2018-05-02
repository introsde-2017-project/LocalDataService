package introsde.project.data.soap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import introsde.project.data.soap.dao.DatabaseDao;

@Entity
@NamedQuery(name="Food.findAll", query="SELECT F FROM Food F")
@XmlRootElement(name="movie")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableGenerator(name = "Food_Gen",
			table = "ID_GEN",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VAL",
			pkColumnValue = "fod_Gen",
			initialValue = 100
			)
	@Id // defines this attributed as the one that identifies the entity 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Food_Gen")
	@Column(name="idFood") // maps the following attribute to a column
	private int idFood;
	@Column(name="name")
	private String name;
	@Column(name="foodType")
	private FoodType type;
	@Column(name="description")
	private String description;

	public Food(){}
	

	public Food(String name, FoodType type, String description) {
		this.name= name;
		this.type= type;
		this.description=description;
	}


	public int getIdFood() {
		return idFood;
	}
	public void setIdFood(int idFood) {
		this.idFood = idFood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FoodType getType() {
		return type;
	}
	public void setType(FoodType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static Food getFoodById(int foodId) {
        EntityManager em = DatabaseDao.instance.createEntityManager();
        Food p = em.find(Food.class, foodId);
        DatabaseDao.instance.closeConnections(em);
        return p;
    }
    
    public static List<Food> getAll() {
        EntityManager em = DatabaseDao.instance.createEntityManager();
        List<Food> list = em.createNamedQuery("Food.findAll", Food.class)
            .getResultList();
        DatabaseDao.instance.closeConnections(em);
        return list;
    }

    public static Food saveFood(Food p){
        EntityManager em = DatabaseDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        Food Food = em.find(Food.class, p.getIdFood());
        DatabaseDao.instance.closeConnections(em);
        return Food;
    } 

    public static Food updateFood(Food p) {
        EntityManager em = DatabaseDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        tx.commit();
        Food Food = em.find(Food.class, p.getIdFood());
        DatabaseDao.instance.closeConnections(em);
        return Food;
    }

    public static void removeFood(Food p) {
        EntityManager em = DatabaseDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        em.remove(p);
        tx.commit();
        DatabaseDao.instance.closeConnections(em);
    }
	
}
