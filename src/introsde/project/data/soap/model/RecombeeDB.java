package introsde.project.data.soap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.adopter.recombee.soap.RecombeeClient;
import introsde.project.adopter.recombee.soap.RecombeeImplService;
import introsde.project.adopter.recombee.soap.RecombeeInterface;



public class RecombeeDB {
	private  RecombeeImplService serviceImp;
	private  RecombeeInterface serviceInt;
	private  RecombeeClient mRecombeeId;
	private  RecombeeClient fRecombeeId;
	
	public RecombeeDB(){
		serviceImp =  new RecombeeImplService();
		serviceInt = serviceImp.getRecombeeImplPort();
		mRecombeeId= setRecombeeClient("introsde-movie","vFHY4J18WnyMsM3kA550soX5HIGiID0ctFiBvFAHcbdu13EY9G7Gh1jr60cUN7Pg");
		fRecombeeId= setRecombeeClient("introsde-food", "rntjKxWkHt56geGH7uF25kVSt4dQhAHx9jPS3v1yId7zZwEQUMlxvpFxxGLn3OMc");
	}
	
	
	public  int addRatingF(int itemId, int personId, double rating, Date timestemp) {			
		return serviceInt.addRating(fRecombeeId, Integer.toString(personId), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}
	public  int addRatingM(int itemId, int personId, double rating, Date timestemp) {			
		return serviceInt.addRating(mRecombeeId, Integer.toString(personId), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}


	public  List<Evaluation> getItemRatingsF(int itemId) {
		//List<Rating> list= new ArrayList<Rating>();
		//for(Rating r:serviceInt.getItemRating(fRecombeeId, Integer.toString(itemId))) {
			//((Rating) r).getItemId();
		//}
		return null;
	}
	public  List<Evaluation> getItemRatingsM(int itemId) {
		return null;
		//return serviceInt.getItemRating(mRecombeeId, Integer.toString(itemId));
	}


	public  void addUserMdb(int idPerson, List<MovieGen> movieGens) {
		List<String> itemType= new ArrayList<String>();
		for(MovieGen m: movieGens) {
			itemType.add(m.toString());
		}
		serviceInt.addUser(mRecombeeId, Integer.toString(idPerson), itemType);
		
	}


	public  void addUserFdb(int idPerson, List<FoodType> foodTypes) {
		List<String> itemType= new ArrayList<String>();
		for(FoodType m: foodTypes) {
			itemType.add(m.toString());
		}
		serviceInt.addUser(fRecombeeId, Integer.toString(idPerson), itemType);
		
	}


	public  List<Movie> getMRec(int idPerson, int quantity) {
		List<Movie> movies= new ArrayList<>();
		List<String> recmded=serviceInt.getRec4User(mRecombeeId, Integer.toString(idPerson), quantity);
		for(String rec: recmded) {
			movies.add(Movie.getMovieById(Integer.valueOf(rec)));
		}
		 
		return movies;
	}


	public  List<Food> getFRec(int idPerson, int quantity) {
		List<Food> foods= new ArrayList<>();
		List<String> recmded=serviceInt.getRec4User(fRecombeeId, Integer.toString(idPerson), quantity);
		for(String rec: recmded) {
			foods.add(Food.getFoodById(Integer.valueOf(rec)));
		}
		 
		return foods;
	}


	public  int modifyRatingM(int idPerson, int itemId, double rating,
			Date timestemp) {
		return serviceInt.modifyRating(mRecombeeId, Integer.toString(idPerson), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}
	public  int modifyRatingF(int idPerson, int itemId, double rating,
			Date timestemp) {
		return serviceInt.modifyRating(mRecombeeId, Integer.toString(idPerson), Integer.toString(itemId), rating, DateToXML.GregorianCalendar(timestemp));
	}


	public  RecombeeClient setRecombeeClient(String string, String string2) {
		return serviceInt.setRecombeeClient(string,string2);
	}


	
	

}
