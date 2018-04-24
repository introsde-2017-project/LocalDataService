package introsde.project.data.soap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


import introsde.project.data.soap.dao.DatabaseDao;



@Entity  // indicates that this class is an entity to persist in DB
@Table(name="Movie") // to whate table must be persisted
@NamedQuery(name="Movie.findAll", query="SELECT M FROM Movie M")
@XmlRootElement(name="movie")
public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name = "Movie_Gen",
			table = "ID_GEN",
			pkColumnName = "GEN_NAME",
			valueColumnName = "GEN_VAL",
			pkColumnValue = "Mve_Gen",
			initialValue = 100
			)
	@Id // defines this attributed as the one that identifies the entity 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Movie_Gen")
	@Column(name="idMovie") // maps the following attribute to a column
	private int idMovie;
	@Column(name="name")
	private String name;
	@Column(name="genere")
	private MovieGen genere;
	
	public Movie() {}
	
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MovieGen getGenere() {
		return genere;
	}
	public void setGenere(MovieGen genere) {
		this.genere = genere;
	}
	
	public static Movie getMovieById(int movieId) {
        EntityManager em = DatabaseDao.instance.createEntityManager();
        Movie p = em.find(Movie.class, movieId);
        DatabaseDao.instance.closeConnections(em);
        return p;
    }
    
    public static List<Movie> getAll() {
        EntityManager em = DatabaseDao.instance.createEntityManager();
        List<Movie> list = em.createNamedQuery("Movie.findAll", Movie.class)
            .getResultList();
        DatabaseDao.instance.closeConnections(em);
        return list;
    }

    public static Movie saveMovie(Movie p){
        EntityManager em = DatabaseDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        Movie Movie = em.find(Movie.class, p.getIdMovie());
        DatabaseDao.instance.closeConnections(em);
        return Movie;
    } 

    public static Movie updateMovie(Movie p) {
        EntityManager em = DatabaseDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        tx.commit();
        Movie Movie = em.find(Movie.class, p.getIdMovie());
        DatabaseDao.instance.closeConnections(em);
        return Movie;
    }

    public static void removeMovie(Movie p) {
        EntityManager em = DatabaseDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        em.remove(p);
        tx.commit();
        DatabaseDao.instance.closeConnections(em);
    }

}