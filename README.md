introsde-2017-project-LocalDataService  
 
 
Identification:  
NAME: Cheema Danish Asghar  
EMAIL: danishasghar.cheema@studenti.unitn.it  
 
Client Code Done by:      
NAME: Main muhammad Faheem - Jan     
EMAIL:main.jan@unitn.it    
 
 Server heroku ULR:     
 Server Git ripo:     
 
 Client Git riop:      
 
ABOUT THE CODE : In this repository "LocalDataService" i have made the following packages.    
1)model    
2)Dao      
3)soap            
in the "model" package there are 2 enums    
1) `FoodType.java` it has some food types defined already. which are the following.

|Indian|Italian|Chinese|Thai|Mexican|  
|------|-------|-------|----|-------|  
2) `MovieGen.java` it has some movies genere defined already as shown in the table, to be used later on.it has some methods like getting list   of all the moviesgenres and some getters and setters. 

|Drama|Comedy|Romance|Action|Adventure|Thriller|Fiction|Animation|Horror|  
|-----|------|-------|------|---------|--------|-------|---------|------|  

then there is one class named as  
3) `Person.java` which has the following attributes:     

|firstName|lastName|userName|password|birthDate|FoodType|MovieGen|  
|---------|--------|--------|--------|---------|--------|--------|  

This person class has many to one relationship with FoodType.java and MovieGen.java. i.e a person can have more than one food and   movies. there are objects are declared in the person class.   

In the "Dao" package there is just one class named as:
1) `DatabaseDao.java` which gives us a connection to the database ,it has some  methods like:  
createEntityManager()    
getEntityManagerFactory()  
getTransaction(EntityManager em).  
it gives me the entity manager object through which i can communicate with the database.  

In the "soap" packgae there is one interface and a class which implement this interface.the methods which are implemented in this   class   are:   
`addNewPerson(Person person)` it adds new person to the database.        
`getPerson(String username)` it returns person given its username.        
`updatePerson(Person person)` it updates person.       
`getFoodTypes()` this method returns food type.      
`getMovieGens()` this method returns Movie genere.      

