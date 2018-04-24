package introsde.project.data.soap.ws;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.project.adopter.recombee.soap.Evaluation;
import introsde.project.data.soap.model.Food;
import introsde.project.data.soap.model.Movie;
import introsde.project.data.soap.model.Person;


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
			@WebParam(name="personId") int personId
			);
	@WebMethod(operationName="getMovieRec")
    @WebResult(name="movielist") 
	public List<Movie> getMovieRec(
			@WebParam(name="quantity") int number
			);
	@WebMethod(operationName="getFoodRec")
    @WebResult(name="listfood") 
	public List<Food> getFoodRec(
			@WebParam(name="quantity") int number
			);
	
	
	
	@WebMethod(operationName="setMovie")
    @WebResult(name="movie") 
	public Movie setMovie(
			@WebParam(name="movie") Movie movie
			);
	@WebMethod(operationName="getMovie")
    @WebResult(name="Movie") 
	public Movie getMovie(
			@WebParam(name="movieId") int movieId
			);
	@WebMethod(operationName="addMovieRating")
    @WebResult(name="int") 
	public int addMovieRating(
			@WebParam(name="movieId") int movieId,
			@WebParam(name="rating") double rating,
			@WebParam(name="timestemp") Date timestemp
			);
	@WebMethod(operationName="modifyMovieRating")
    @WebResult(name="int") 
	public int modifyMovieRating(
			@WebParam(name="movieId") int movieId,
			@WebParam(name="rating") double rating,
			@WebParam(name="timestemp") Date timestemp
			);
	@WebMethod(operationName="getMovieRatings")
    @WebResult(name="MovieRatingList") 
	public List<Evaluation> getMovieRating(
			@WebParam(name="movieId") int movieId
			);
	
	
	@WebMethod(operationName="setFood")
    @WebResult(name="Food") 
	public Food setFood(
			@WebParam(name="food") Food food
			);
	@WebMethod(operationName="getFood")
    @WebResult(name="Food") 
	public Food getFood(
			@WebParam(name="foodId") int foodId
			);
	@WebMethod(operationName="addFoodRating")
    @WebResult(name="int") 
	public int addFoodRating(
			@WebParam(name="foodId") int foodId,
			@WebParam(name="rating") double rating,
			@WebParam(name="timestemp") Date timestemp
			);
	@WebMethod(operationName="modifyFoodRating")
    @WebResult(name="int") 
	public int modifyFoodRating(
			@WebParam(name="foodId") int foodId,
			@WebParam(name="rating") double rating,
			@WebParam(name="timestemp") Date timestemp
			);
	@WebMethod(operationName="getFoodRating")
    @WebResult(name="FoodRatingList") 
	public List<Evaluation> getFoodRating(
			@WebParam(name="foodId") int foodId
			);
}
