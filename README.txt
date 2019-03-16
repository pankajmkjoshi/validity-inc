Built With
Java version - > "1.8.0_191"
Build Tool   - > Maven : Apache Maven 3.6.0
Spring Boot  - > 2.1.3.RELEASE

Instructions:
1. Check version of java with "java -version".
2. Install Maven and set it as an environment variable.
3. Check whether Maven is installed using "mvn -version".
4. Compile project by running this command - "mvn clean install".

Installing
git clone https://github.com/pankajmkjoshi/validity-inc.git

*******************************************************************************************
************************How to execute application*****************************************
*******************************************************************************************
1-st
a) From this package -> \validate-data-set-app-spring-boot>
b) Run the command - mvn clean install
c) Execute validate-data-set-app-demo-0.0.1-SNAPSHOT.jar file (under target directory) from command prompt like below
java -jar target/validate-data-set-app-demo-0.0.1-SNAPSHOT.jar

2-nd
Run the following command from this package : \validate-data-set-app-spring-boot> -> mvn spring-boot:run

Once spring boot is up and run please use below url to see all the end point listed.
http://localhost:8080/swagger-ui.html


*******************************************************************************************
**************************************Approach*********************************************
*******************************************************************************************

1. Standard Spring Boot application with exception handling, controller and service classes.

2. Swagger provides all the end point listed and from there each request can be placed.

3. End points exposed
a) GET  /validates/advance
b) GET  /validates/normal

Algorithm : Double Metaphone algorithm used to calculate the phonics score of every row for csv. The score
is getting calculated based on all the properties passed. Once we have the list of object returns we will
convert them in to data transfer object. Duplicate and non-duplicate records will be filtered based on
phonetic score with the help of lambda expression which intern calls to hashcode and equals method of PersonBean.

Others : Soundex, Metaphone

Response
{
  "duplicate": [
    {
      "address1": "string",
      "address2": "string",
      "city": "string",
      "company": "string",
      "email": "string",
      "first_name": "string",
      "last_name": "string",
      "phone": "string",
      "phoneticScore": "string",
      "state": "string",
      "state_long": "string",
      "zip": "string"
    }
  ],
  "nonDuplicate": [
    {
      "address1": "string",
      "address2": "string",
      "city": "string",
      "company": "string",
      "email": "string",
      "first_name": "string",
      "last_name": "string",
      "phone": "string",
      "phoneticScore": "string",
      "state": "string",
      "state_long": "string",
      "zip": "string"
    }
  ],
  "numberOfDuplicate": 0,
  "numberOfNonDuplicate": 0,
  "totalItems": 0
}


Feedback:
1) Got to learn some new algorithms which i had no clue. Thanks for this exercise.
2) It took close to 6-7 hours wrapping entire exercise.
3) PS : README.md was crashing my intelliJ so had to go for txt file.

