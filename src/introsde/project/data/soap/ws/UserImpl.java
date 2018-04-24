package introsde.project.data.soap.ws;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.data.soap.model.Food;
import introsde.project.data.soap.model.Movie;
import introsde.project.data.soap.model.Person;
import introsde.project.data.soap.model.RecombeeDB;

@WebService(endpointInterface = "introsde.project.data.soap.ws.UserInterface")
public class UserImpl implements UserInterface{
	@Resource
    WebServiceContext wsctx;
	
	//RecombeeDB recombeeDB;
	
	public UserImpl() {
		//RecombeeDB= new RecombeeDB();
	}

	@Override
	public Person addNewPerson(Person person) {
		Person p=Person.savePerson(person);
		RecombeeDB.addUserMdb(p.getIdPerson(),p.getMovieGens());
		RecombeeDB.addUserFdb(p.getIdPerson(),p.getFoodTypes());
		return p;
	}

	@Override
	public Person getPerson(int personId) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonById(personId).getUserName().equals(username) 
	    		&& Person.getPersonById(personId).getPassword().equals(password)){
        	return Person.getPersonById(personId);
	    }else{
        	return null;
        }
	}


	@Override
	public Movie getMovie(int movieId) {
		return Movie.getMovieById(movieId);
	}

	@Override
	public int addMovieRating(int movieId, double rating, Date timestemp) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    Person p=Person.getPersonByUserName(username);
	    if (p!=null 
	    		&& p.getPassword().equals(password)
	    		&& Movie.getMovieById(movieId)!=null){
	    	return RecombeeDB.addRatingM(movieId,p.getIdPerson(),rating,timestemp);
	    }else{
        	return -1;
        }
	}

	@Override
	public List<Evaluation> getMovieRating(int movieId) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)
	    		&& Movie.getMovieById(movieId)!=null){
	    	return RecombeeDB.getItemRatingsF(movieId);
	    }else{
        	return null;
        }
	}


	@Override
	public Food getFood(int foodId) {
		return Food.getFoodById(foodId);
	}

	@Override
	public int addFoodRating(int foodId, double rating, Date timestemp) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    Person p=Person.getPersonByUserName(username);
	    if (p!=null 
	    		&& p.getPassword().equals(password)
	    		&& Food.getFoodById(foodId)!=null){
	    	return RecombeeDB.addRatingF(foodId,p.getIdPerson(),rating,timestemp);
	    }else{
        	return -1;
        }
	}

	@Override
	public List<Evaluation> getFoodRating(int foodId) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)
	    		&& Food.getFoodById(foodId)!=null){
	    	return RecombeeDB.getItemRatingsM(foodId);
	    }else{
        	return null;
        }
	}

	@Override
	public Movie setMovie(Movie movie) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)){
	    	return Movie.saveMovie(movie);
	    }else{
        	return null;
        }
	}

	@Override
	public Food setFood(Food food) {
MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)){
	    	return Food.saveFood(food);
	    }else{
        	return null;
        }
	}

	@Override
	public List<Movie> getMovieRec(int number) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)){
	    	return RecombeeDB.getMRec(Person.getPersonByUserName(username).getIdPerson(),number);
	    }else{
        	return null;
        }
	}

	@Override
	public List<Food> getFoodRec(int number) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)){
	    	return RecombeeDB.getFRec(Person.getPersonByUserName(username).getIdPerson(),number);
	    }else{
        	return null;
        }
	}

	@Override
	public int modifyMovieRating(int movieId, double rating, Date timestemp) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)){
	    	return RecombeeDB.modifyRatingM(Person.getPersonByUserName(username).getIdPerson(),movieId,rating,timestemp);
	    }else{
        	return -1;
        }
	}

	@Override
	public int modifyFoodRating(int foodId, double rating, Date timestemp) {
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	    Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	    List<?> userList = (List<?>) http_headers.get("Username");
	    List<?> passList = (List<?>) http_headers.get("Password");

	    String username = "";
	    String password = "";
	        
	    if(userList!=null){
	       	//get username
	       	username = userList.get(0).toString();
	    }
	        	
	    if(passList!=null){
        	//get password
	    	password = passList.get(0).toString();
	    }
	        	
	    //Should validate username and password with database
	    if (Person.getPersonByUserName(username)!=null
	    		&& Person.getPersonByUserName(username).getPassword().equals(password)){
	    	return RecombeeDB.modifyRatingF(Person.getPersonByUserName(username).getIdPerson(),foodId,rating,timestemp);
	    }else{
        	return -1;
        }
	}

}
