package introsde.project.data.soap.init;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.recombee.api_client.api_requests.AddRating;
import com.recombee.api_client.api_requests.AddUser;
import com.recombee.api_client.api_requests.Request;
import com.recombee.api_client.api_requests.SetUserValues;

import introsde.project.adopter.recombee.soap.RecombeeImplService;
import introsde.project.adopter.recombee.soap.RecombeeInterface;
import introsde.project.data.soap.model.Food;
import introsde.project.data.soap.model.FoodType;
import introsde.project.data.soap.model.Movie;
import introsde.project.data.soap.model.MovieGen;
import introsde.project.data.soap.model.Person;
import introsde.project.data.soap.model.RecombeeDB;

public class DatabaseINIT {
	private static RecombeeImplService serviceImp = new RecombeeImplService();
	private static RecombeeInterface serviceInt=  serviceImp.getRecombeeImplPort();
	private static String foodRecombeeDB= "foodDB";
	private static String movieRecombeeDB= "movieDB";
	
	public static void initializeDB(){
		
		
		
		Person p= new Person("george","michael", "username","password","1980-06-20", new LinkedList<FoodType>() {{
			add(FoodType.Chinese);
			add(FoodType.Indian);
		}},
		new LinkedList<MovieGen>() {{
			add(MovieGen.Action);
			add(MovieGen.Adventure);
		}}
		);
		Person q=Person.savePerson(p);
		System.out.println(q.getIdPerson());
		
		//adding in Food Recombee DB
		List<String> l= new ArrayList<String>();
		for(FoodType f: p.getFoodTypes()) 
			l.add(f.name());
		serviceInt.addUser(foodRecombeeDB, Integer.toString(p.getIdPerson()), l);
		
		//adding to movie Recombee DB 
		l= new ArrayList<String>();
		for(MovieGen f: p.getMovieGens()) 
			l.add(f.name());
		serviceInt.addUser(movieRecombeeDB, Integer.toString(p.getIdPerson()), l);
		
		
		
		
		
		//RecombeeDB.addUserMdb(p.getIdPerson(),p.getMovieGens());
		//RecombeeDB.addUserFdb(p.getIdPerson(),p.getFoodTypes());
		
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
		//DatabaseINIT.initializeDB();
		//initMovie();
	}
	
	
	
}
