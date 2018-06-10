# introsde-2017-project-LocalDataService  
 
 
Heroku WSDL ULR: https://dataservice-introsde-2018.herokuapp.com/ws/database?wsdl    
API Documantation: https://documenter.getpostman.com/view/2954866/RWEcNfqZ  
Project Documantation: https://github.com/introsde-2017-project/documentation#introsde-project-2017  

## introduction:
This is a local data layer for the `knowYourCity` app which uses local sqlite for store the user .   
Its a Soap Service which can be used via WSDL in order to save, modify, and get data like persisting new user or getting all the movie gen and movie types in the DataBase. 
 
## Architecture:
"LocalDataService" is consist of following packages.    
* model -> contains all the Enum, Entity and Business logic classes required to persist and retrive the data from local DB.  
* Dao -> it is used to handel data access object requests to local sqlite database defined in persistence.xml      
* soap -> it defines all the methods visible to service clients.            

## Implementation:
in the `model` package there are 2 enums and an Entity class  
1) `FoodType.java` it has some food types defined already. which are the following.

|Indian|Italian|Chinese|Thai|Mexican|  
|------|-------|-------|----|-------|  
2) `MovieGen.java` it has some movies genere defined already as shown in the table, to be used later on.

|Drama|Comedy|Romance|Action|Adventure|Thriller|Fiction|Animation|Horror|  
|-----|------|-------|------|---------|--------|-------|---------|------|  
 
3) `Person.java` which has the following attributes:     

|firstName|lastName|userName|password|birthDate|FoodType|MovieGen|  
|---------|--------|--------|--------|---------|--------|--------|  

This person class has many to one relationship with FoodType.java and MovieGen.java. i.e a person can have more than one food and movies.   

In the `Dao` package there is just one class named as:
* `DatabaseDao.java` which gives us a connection to the database ,it has some  methods like:  
 * createEntityManager()    
 * getEntityManagerFactory()  
 * getTransaction(EntityManager)  

In the `soap` packgae there is an interface and a class which implement this interface.
The methods which are availabe to service client are:   
`addNewPerson(Person)` it adds new person to the database.        
`getPerson(username)` it returns person given its username.  
`getPersonByToken(token)` returns a person.
`getAllPerson()` return list of persons. used for debug perpose only.
`updatePerson(Person person)` it updates person.       
`getFoodTypes()` this method returns food type.      
`getMovieGens()` this method returns Movie genere.      


## Execuation:
1: clone or download the code from server git repo.  
2: run following commands on command line   
```
git init
git add .
git commit -am "initial commit"
heroku create NAME-OF-HEROKU-APP
git push heroku master 

```
in my project NAME-OF-HEROKU-APP="dataservice-introsde-2018"
