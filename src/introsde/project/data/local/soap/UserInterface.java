package introsde.project.data.local.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.project.data.local.model.FoodType;
import introsde.project.data.local.model.MovieGen;
import introsde.project.data.local.model.Person;


@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface UserInterface {
	
	
	@WebMethod(operationName="addPerson")
    @WebResult(name="Person") 
	public Person addNewPerson(
			@WebParam(name="person") Person person
			);
	@WebMethod(operationName="getPerson")
    @WebResult(name="Person") 
	public Person getPerson(
			@WebParam(name="username") String username
			);
	@WebMethod(operationName="updatePerson")
    @WebResult(name="Person") 
	public Person updatePerson(
			@WebParam(name="person") Person person
			);
	
	@WebMethod(operationName="getFoodTypes")
    @WebResult(name="FoodTypeList") 
	public List<FoodType> getFoodTypes();
	
	@WebMethod(operationName="getMovieGens")
    @WebResult(name="MovieGenList") 
	public List<MovieGen> getMovieGens();
	
//	@WebMethod(operationName="getMovieRec")
//    @WebResult(name="movielist") 
//	public List<String> getMovieRec(
//			@WebParam(name="personId") int personId,
//			@WebParam(name="quantity") int number
//			);
//	@WebMethod(operationName="getFoodRec")
//    @WebResult(name="listfood") 
//	public List<String> getFoodRec(
//			@WebParam(name="personId") int personId,
//			@WebParam(name="quantity") int number
//			);
	
	
	
//	@WebMethod(operationName="setMovie")
//    @WebResult(name="Movie") 
//	public Movie setMovie(
//			@WebParam(name="movie") Movie movie
//			);
//	@WebMethod(operationName="getMovie")
//    @WebResult(name="Movie") 
//	public Movie getMovie(
//			@WebParam(name="movieId") int movieId
//			);
//	@WebMethod(operationName="addMovieRating")
//    @WebResult(name="int") 
//	public int addMovieRating(
//			@WebParam(name="personId") int personId,
//			@WebParam(name="movieId") int movieId,
//			@WebParam(name="rating") double rating,
//			@WebParam(name="timestemp") Date timestemp
//			);
//	@WebMethod(operationName="modifyMovieRating")
//    @WebResult(name="int") 
//	public int modifyMovieRating(
//			@WebParam(name="personId") int personId,
//			@WebParam(name="movieId") int movieId,
//			@WebParam(name="rating") double rating,
//			@WebParam(name="timestemp") Date timestemp
//			);
//	@WebMethod(operationName="getMovieRatings")
//    @WebResult(name="MovieRatingList") 
//	public List<Evaluation> getMovieRatings(
//			@WebParam(name="movieId") int movieId
//			);
//	
//	
//	@WebMethod(operationName="setFood")
//    @WebResult(name="Food") 
//	public Food setFood(
//			@WebParam(name="food") Food food
//			);
//	@WebMethod(operationName="getFood")
//    @WebResult(name="Food") 
//	public Food getFood(
//			@WebParam(name="foodId") int foodId
//			);
//	@WebMethod(operationName="addFoodRating")
//    @WebResult(name="int") 
//	public int addFoodRating(
//			@WebParam(name="personId") int personId,
//			@WebParam(name="foodId") int foodId,
//			@WebParam(name="rating") double rating,
//			@WebParam(name="timestemp") Date timestemp
//			);
//	@WebMethod(operationName="modifyFoodRating")
//    @WebResult(name="int") 
//	public int modifyFoodRating(
//			@WebParam(name="personId") int personId,
//			@WebParam(name="foodId") int foodId,
//			@WebParam(name="rating") double rating,
//			@WebParam(name="timestemp") Date timestemp
//			);
//	@WebMethod(operationName="getFoodRatings")
//    @WebResult(name="FoodRatingList") 
//	public List<Evaluation> getFoodRatings(
//			@WebParam(name="foodId") int foodId
//			);
	
}
