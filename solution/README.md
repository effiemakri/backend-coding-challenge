README
====

>_"Hi FE Developer,_

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
(I've used mySQLWorkbench to create all the above - and have used 'Forward Engineer' to generate the SQL - this is provided in the `schema.sql`. Please make sure you have `MySQL` running first). 

Compile the web-app backend
--------------


Run the web-app backend
--------------

