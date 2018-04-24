package introsde.project.data.soap.init;

import java.util.LinkedList;

import introsde.project.data.soap.model.Food;
import introsde.project.data.soap.model.FoodType;
import introsde.project.data.soap.model.Movie;
import introsde.project.data.soap.model.MovieGen;
import introsde.project.data.soap.model.Person;

public class DatabaseINIT {
	public static void initializeDB(){
		
		//Activity ar= setActivity("Meeting","Project meeting","Torino","2018-01-15T09:00:00.0",ActivityType.WorkMeeting,8);
		//Food f= new Food("name",FoodType.Chinese,"description");
		//Food.saveFood(f);
		//Movie m= new Movie("movie1",MovieGen.Action);
		//Movie.saveMovie(m);
		Person p= new Person("george","michael", "username","password","1980-06-20", new LinkedList<FoodType>() {{
			add(FoodType.Chinese);
			add(FoodType.Indian);
		}},
		new LinkedList<MovieGen>() {{
			add(MovieGen.Action);
			add(MovieGen.Adventure);
		}}
		);
		p=Person.savePerson(p);
		System.out.println(p.getIdPerson());
		
//		//ar= setActivity("Fundraising","Fundraising event","Trento","2018-01-16T09:00:00.0",ActivityType.Culture,6);
//		p= setPerson( "1992-03-19", "Fillipo","Max","username1","password1");
//		System.out.println(p.getIdPerson());
//		
//		//ar= setActivity("Hiking","Hiking in monte bianco","Torino","2018-01-17T09:00:00.0",ActivityType.Sport,3);
//		p= setPerson("1995-04-21", "Franco","Charli","username2","password2");
//		System.out.println(p.getIdPerson());
//		
//		//ar= setActivity("Get Together","Alumnus Get together","Venezia","2018-01-23T09:00:00.0",ActivityType.Social,7);
//		p= setPerson("1985-09-22", "Ali","Muhammad","username3","password3");
//		System.out.println(p.getIdPerson());
//		
//		//ar= setActivity("Summer School","Summer school","Milano","2018-01-30T09:00:00.0",ActivityType.Sport,9);
//		p= setPerson("1987-08-23", "Hamid","Raza","username3","password3");
//		System.out.println(p.getIdPerson());
	}
	
	public static void main(String[] args) {
		DatabaseINIT.initializeDB();
	}
	
}
