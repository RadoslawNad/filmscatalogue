# filmcatalogue
> A console application for movie catalogue.

## General info
These are two applications for film cataloging.
1. **"catalogue"** located in the com.radek.catalogue package. For connecting to the database uses JDBC 
and the SQL query language. With the application you can: 
   * Show movies list, 
   * Add new movie, 
   * Remove movie, 
   * Add movie rating

2. **"jpacatalogue"** located in the com.radek.jpacatalogue package. 
For connecting to the database uses JPA specifications and 
Hibernate. With the application you can: 
   * Show movies list
   * Add new movie
   * Remove movie
   * Movies ratings
   * Search movie
   * Edit movie
   * Add comment
   * Show comment
 
## Technologies
CATALOGUE
* JDBC
* SQL

JPACATALOGUE
* JPA
* HIBERNATE
* HQL

## Setup
* Setup CATALOGUE
    * clone repository
    * go to DAO class in com.radek.catalogue package 
      and replace the url, username, password fields 
      to what you need to connect to your database
    * create consolelibrary database
    * create console table(you can use the console.sql file )
    
* Setup JPACATALOGUE
    * clone repository
    * open the persistence.xml file in resources/META-INF/ directory,
      replace the values in the properties to connect to your database
      
      
        