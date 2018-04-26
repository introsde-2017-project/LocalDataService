package introsde.project.data.soap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.adopter.recombee.soap.RecombeeImplService;
import introsde.project.adopter.recombee.soap.RecombeeInterface;



public class RecombeeDB {
	private static RecombeeImplService serviceImp = new RecombeeImplService();
	private static RecombeeInterface serviceInt= serviceImp.getRecombeeImplPort();
	private static String foodRecombeeDB= "foodDB";
	private static String movieRecombeeDB= "movieDB";
	
	
	public RecombeeDB(){}
	
	
	public static  int addRatingF(int itemId, int personId, double rating, Date timestemp) {			
		return serviceInt.addRating(foodRecombeeDB, Integer.toString(personId), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}
	public static  int addRatingM(int itemId, int personId, double rating, Date timestemp) {			
		return serviceInt.addRating(movieRecombeeDB, Integer.toString(personId), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}


	public static  List<Evaluation> getItemRatingsF(int itemId) {
		return serviceInt.getItemRating(foodRecombeeDB, Integer.toString(itemId));
	}
	public static  List<Evaluation> getItemRatingsM(int itemId) {
		return serviceInt.getItemRating(movieRecombeeDB, Integer.toString(itemId));
	}


	public static  void addUserMdb(int idPerson, List<MovieGen> movieGens) {
		List<String> itemType= new ArrayList<String>();
		for(MovieGen m: movieGens) {
			itemType.add(m.name());
		}
		serviceInt.addUser(movieRecombeeDB, Integer.toString(idPerson), itemType);
		
	}


	public static  void addUserFdb(int idPerson, List<FoodType> foodTypes) {
		List<String> itemType= new ArrayList<String>();
		for(FoodType m: foodTypes) {
			itemType.add(m.name());
		}
		serviceInt.addUser(foodRecombeeDB, Integer.toString(idPerson), itemType);
		
	}


	public static  List<Movie> getMRec(int idPerson, int quantity) {
		List<Movie> movies= new ArrayList<>();
		List<String> recmded=serviceInt.getRec4User(movieRecombeeDB, Integer.toString(idPerson), quantity);
		for(String rec: recmded) {
			movies.add(Movie.getMovieById(Integer.valueOf(rec)));
		}
		 
		return movies;
	}


	public static  List<Food> getFRec(int idPerson, int quantity) {
		List<Food> foods= new ArrayList<>();
		List<String> recmded=serviceInt.getRec4User(foodRecombeeDB, Integer.toString(idPerson), quantity);
		for(String rec: recmded) {
			foods.add(Food.getFoodById(Integer.valueOf(rec)));
		}
		 
		return foods;
	}


	public static  int modifyRatingM(int idPerson, int itemId, double rating,
			Date timestemp) {
		return serviceInt.modifyRating(movieRecombeeDB, Integer.toString(idPerson), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}
	public static  int modifyRatingF(int idPerson, int itemId, double rating,
			Date timestemp) {
		return serviceInt.modifyRating(movieRecombeeDB, Integer.toString(idPerson), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}


	public static void resetDB() {
		serviceInt.resetBD("foodDB");
		serviceInt.resetBD(movieRecombeeDB);
		
	}


	
	

}
