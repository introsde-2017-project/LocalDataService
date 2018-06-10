package introsde.project.data.local.soap;

import java.util.List;

import javax.jws.WebService;

import introsde.project.data.local.model.FoodType;
import introsde.project.data.local.model.MovieGen;
import introsde.project.data.local.model.Person;

@WebService(endpointInterface = "introsde.project.data.local.soap.UserInterface")
public class UserImpl implements UserInterface{
	
	public UserImpl() {
		
	}

	@Override
	public Person addNewPerson(Person person) {
		Person p=Person.savePerson(person);
		if(p== null)
			throw new IllegalArgumentException("The value is already in the list.");
		return p;
	}

	@Override
	public Person getPerson(String username) {
		Person p=Person.getPersonByUserName(username);
		if(p==null)
			throw new IllegalArgumentException("No User with username: \""+username+"\" in the DB");
		return p;
	}

	@Override
	public Person updatePerson(Person person) {
		Person p= Person.updatePerson(person);
		if(p==null)
			throw new IllegalArgumentException("No User with username: \""+person.getUserName()+"\" in the DB");
		return p;
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
		Person p= Person.getPersonByToken(token);
		if(p==null)
			throw new IllegalArgumentException("No User with token: \""+token+"\" in the DB");
		return p;
	}




}
