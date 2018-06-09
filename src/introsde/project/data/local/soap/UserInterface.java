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
	@WebMethod(operationName="getPersonByToken")
    @WebResult(name="Person") 
	public Person getPersonByToken(
			@WebParam(name="token") String token
			);
//	@WebMethod(operationName="getAllPerson")
//    @WebResult(name="PersonList") 
//	public List<Person> getAllPerson(
//			);
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
	
	
}
