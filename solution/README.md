README
====

>_"Hi FE Developer,_
>
>_Hope you are having a nice time in France.
>Thank you very much for the UI you created and for the instructions on how to prep the project._
>
>_I have now created the web-app backend and below you will find instructions on how to run it._
>
>_P.S. I hope you don't mind, but I had to make some configuration changes to your frontend so that it can connect to the web-app backend._
>
>_Take care_
>
> _Candidate Developer"_

Instructions
===

Create the database and the database user
--------------
The web-app backend saves the expenses submitted to a database, and it is configured to connect to a pre-existing database with a specific name, as a specific user.
> 1. Create a database user with the username `engagetechuser` and password `engagetech`.
> 0. Create a database (`engagetechdb`), and a table `expenses`with columns `id`, `date`, `amount`, `vat` and `reason`. 

`schema.sql`contains the necessary sql to perform the above. Please make sure you have `MySQL` running. 

Compile the web-app backend
--------------
You will need maven to build the backend application. Please make sure you have maven v3x installed on your machine.

In a terminal window in the 'solution' directory, on the command line type: `mvn clean package`. This will build the backend and generate an executable jar.

Run the web-app backend
--------------
Once the build finishes, run the application by typing: `java -jar ./target/backend-coding-challenge-0.0.1-SNAPSHOT.jar`. The backend will run on localhost:8081.

Final Words
===

### Framework
The web-app backend has been developed using the Spring Framework:
* Spring Boot executable, 
* SpringMVC for the web-functionality, 
* Spring Data JPA for the persistence functionality using MySQL.

### Application Server Used
Spring Boot by default comes bundled with tomcat

### Database used
MySQL

### Final notes
The final code submitted has endeavoured to cover all the coding challenges.
