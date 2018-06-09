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




}
