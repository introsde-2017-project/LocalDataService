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
	
	
	public static  int addFoodRating(int itemId, int personId, double rating, Date timestemp) {			
		return serviceInt.addRating(foodRecombeeDB, Integer.toString(personId), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}
	public static  int addMovieRating(int itemId, int personId, double rating, Date timestemp) {			
		return serviceInt.addRating(movieRecombeeDB, Integer.toString(personId), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}


	public static  List<Evaluation> getFoodRatings(int itemId) {
		return serviceInt.getItemRating(foodRecombeeDB, Integer.toString(itemId));
	}
	public static  List<Evaluation> getMovieRatings(int itemId) {
		return serviceInt.getItemRating(movieRecombeeDB, Integer.toString(itemId));
	}


	//adding a user in recombee movie database
	public static void addUserMdb(int idPerson, List<MovieGen> movieGens) {
		if(Person.getPersonById(idPerson)==null
				&& movieGens.isEmpty()) 
			return;
		
		List<String> itemType= new ArrayList<String>();
		for(MovieGen m: movieGens) {
			itemType.add(m.name());
		}
		serviceInt.addUser(movieRecombeeDB, Integer.toString(idPerson), itemType);
		
	}

	
	//adding a user in recombee food database
	public static  void addUserFdb(int idPerson, List<FoodType> foodTypes) {
		if(Person.getPersonById(idPerson)==null
				&& foodTypes.isEmpty()) 
			return;
		
		
		List<String> itemType= new ArrayList<String>();
		for(FoodType m: foodTypes) {
			itemType.add(m.name());
		}
		serviceInt.addUser(foodRecombeeDB, Integer.toString(idPerson), itemType);
		
	}


	public static  List<String> getMovieRec(int idPerson, int quantity) {
//		List<Movie> movies= new ArrayList<>();
//		List<String> recmded=serviceInt.getRec4User(movieRecombeeDB, Integer.toString(idPerson), quantity);
//		for(String rec: recmded) {
//			movies.add(Movie.getMovieById(Integer.valueOf(rec)));
//		}
		 
		return serviceInt.getRec4User(movieRecombeeDB, Integer.toString(idPerson), quantity);
	}


	public static  List<String> getFoodRec(int idPerson, int quantity) {
//		List<Food> foods= new ArrayList<>();
//		List<String> recmded=serviceInt.getRec4User(foodRecombeeDB, Integer.toString(idPerson), quantity);
//		for(String rec: recmded) {
//			foods.add(Food.getFoodById(Integer.valueOf(rec)));
//		}
//		 
//		return foods;
		
		return serviceInt.getRec4User(foodRecombeeDB, Integer.toString(idPerson), quantity);
	}


	public static  int modifyMovieRating(int idPerson, int itemId, double rating,
			Date timestemp) {
		return serviceInt.modifyRating(movieRecombeeDB, Integer.toString(idPerson), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}
	public static  int modifyFoodRating(int idPerson, int itemId, double rating,
			Date timestemp) {
		return serviceInt.modifyRating(movieRecombeeDB, Integer.toString(idPerson), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}


	public static void addMovie(int idMovie, MovieGen genere) {
		serviceInt.additem(movieRecombeeDB, Integer.toString(idMovie), genere.name());
		
	}


	public static void addFood(int idFood, FoodType type) {
		serviceInt.additem(foodRecombeeDB, Integer.toString(idFood), type.name());
		
	}


	
	

}
