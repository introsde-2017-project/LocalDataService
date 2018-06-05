introsde-2017-projecr-DAO
introsde-2017-project-LocalDataService
 
 
Identification:
NAME: Cheema Danish Asghar
EMAIL: danishasghar.cheema@studenti.unitn.it
 
Client Code Done by:
NAME: 
EMAIL:
NAME: Main muhammad Faheem - Jan 
EMAIL:main.jan@unitn.it
 
 Server heroku ULR: 
 Server Git ripo: 
 
 Client Git riop:
 
ABOUT THE CODE : In this ripository "LocalDataService" i have made three packages as 1)Dao 2)model 3)soap.    
in the "model" package there are 2 enums  1) FoodType.java which has some attributes like name of the food and type etc etc  
and some foods are defined and there are some methods which use these attributes and some getters and setters 2) MovieGen.java  
which has some movies defined already to be used later on.it has some methods like getting list of all the moviesgenres and some  
getters and setters. then there is one class named as "Person.java" which has some attributes like firstname,lastname,id,password       
and it has one-to-many relation with the with FoodType.java and MovieGen.java. i.e a person can have more than one food and movies.      
there are objects are declared in the person class.
In the "Dao" package there is just one class named as "DatabaseDao.java" which gives us a connection to the database ,it has some   methods like, EntityManager createEntityManager(),EntityManagerFactory getEntityManagerFactory(),EntityTransaction     getTransaction(EntityManager em). it gives me the entity manager object through which i can communicate with the database.  
In the "soap" packgae there is one interface and a class which implement this interface.the methods which are implemented in this class  are:  Person addNewPerson(Person person),Person getPerson(String username),Person updatePerson(Person    person),getFoodTypes(),List<MovieGen> getMovieGens().

