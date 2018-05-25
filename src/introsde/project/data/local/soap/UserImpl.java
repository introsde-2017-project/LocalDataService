package introsde.project.data.local.soap;

import java.util.List;

import javax.jws.WebService;

import introsde.project.data.local.model.FoodType;
import introsde.project.data.local.model.MovieGen;
import introsde.project.data.local.model.Person;

@WebService(endpointInterface = "introsde.project.data.local.soap.UserInterface")
public class UserImpl implements UserInterface{
	//@Resource
    //WebServiceContext wsctx;
	
	
	public UserImpl() {
		
	}

	@Override
	public Person addNewPerson(Person person) {
		Person p=Person.savePerson(person);
		return p;
	}

	@Override
	public Person getPerson(String username) {
		return Person.getPersonByUserName(username);

	}

	@Override
	public Person updatePerson(Person person) {
		return Person.updatePerson(person);
	}

	@Override
	public List<FoodType> getFoodTypes() {
		
		return FoodType.getAll();
	}

	@Override
	public List<MovieGen> getMovieGens() {
		return MovieGen.getAll();
	}

	@Override
	public List<Person> getAllPerson() {
		return Person.getAll();
	}

	@Override
	public Person getPersonByToken(String token) {
		return Person.getPersonByToken(token);
	}


//	@Override
//	public Movie getMovie(int movieId) {
//		return Movie.getMovieById(movieId);
//	}
//
//	@Override
//	public int addMovieRating(int personId, int movieId, double rating, Date timestemp) {
//		if(Person.getPersonById(personId)!=null
//				&&Movie.getMovieById(movieId)!=null) {
//			return RecombeeDB.addMovieRating(movieId,personId,rating,timestemp);
//		}else{
//        	return -1;
//        }
//		
//	}

//	@Override
//	public List<Evaluation> getMovieRatings(int movieId) {
//		if (Movie.getMovieById(movieId)!=null){
//	    	return RecombeeDB.getMovieRatings(movieId);
//	    }else{
//        	return null;
//        }
//		MessageContext mctx = wsctx.getMessageContext();
//		
//		//get detail from request headers
//	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
//	    List<?> userList = (List<?>) http_headers.get("Username");
//	    List<?> passList = (List<?>) http_headers.get("Password");
//
//	    String username = "";
//	    String password = "";
//	        
//	    if(userList!=null){
//	       	//get username
//	       	username = userList.get(0).toString();
//	    }
//	        	
//	    if(passList!=null){
//        	//get password
//	    	password = passList.get(0).toString();
//	    }
//	        	
//	    //Should validate username and password with database
//	    if (Person.getPersonByUserName(username)!=null
//	    		&& Person.getPersonByUserName(username).getPassword().equals(password)
//	    		&& Movie.getMovieById(movieId)!=null){
//	    	return RecombeeDB.getItemRatingsF(movieId);
//	    }else{
//        	return null;
//        }
//	}
//
//
//	@Override
//	public Food getFood(int foodId) {
//		return Food.getFoodById(foodId);
//	}
//
//	@Override
//	public int addFoodRating(int personId,int foodId, double rating, Date timestemp) {
//		if (Person.getPersonById(personId)!=null 
//	    		&& Food.getFoodById(foodId)!=null){
//	    	return RecombeeDB.addFoodRating(foodId,personId,rating,timestemp);
//	    }else{
//        	return -1;
//        }
//		
//	}
//
//	@Override
//	public List<Evaluation> getFoodRatings(int foodId) {
//		if (Food.getFoodById(foodId)!=null){
//	    	return RecombeeDB.getFoodRatings(foodId);
//	    }else{
//        	return null;
//        }
//		
//	}
//
//	@Override
//	public Movie setMovie(Movie movie) {
//		Movie m= Movie.saveMovie(movie);
//		RecombeeDB.addMovie(m.getIdMovie(),m.getGenere());
//		return m;
//	}
//
//	@Override
//	public Food setFood(Food food) {
//		Food f= Food.saveFood(food);
//		RecombeeDB.addFood(f.getIdFood(),f.getType());
//		return f;
//	}
//
//	@Override
//	public List<String> getMovieRec(int personId,int number) {
//		if (Person.getPersonById(personId)!=null){
//	    	return RecombeeDB.getMovieRec(Person.getPersonById(personId).getIdPerson(),number);
//	    }else{
//        	return null;
//        }
//		
//	}
//
//	@Override
//	public List<String> getFoodRec(int personId,int number) {
//		if (Person.getPersonById(personId)!=null){
//	    	return RecombeeDB.getFoodRec(Person.getPersonById(personId).getIdPerson(),number);
//	    }else{
//        	return null;
//        }
//	}
//
//	@Override
//	public int modifyMovieRating(int personId,int movieId, double rating, Date timestemp) {
//		if (Person.getPersonById(personId)!=null
//				&& Movie.getMovieById(movieId)!=null){
//	    	return RecombeeDB.modifyMovieRating(Person.getPersonById(personId).getIdPerson(),movieId,rating,timestemp);
//	    }else{
//        	return -1;
//        }
//	}
//
//	@Override
//	public int modifyFoodRating(int personId,int foodId, double rating, Date timestemp) {
//		if (Person.getPersonById(personId)!=null
//	    		&& Food.getFoodById(foodId)!=null){
//	    	return RecombeeDB.modifyFoodRating(Person.getPersonById(personId).getIdPerson(),foodId,rating,timestemp);
//	    }else{
//        	return -1;
//        }
//	}


}
