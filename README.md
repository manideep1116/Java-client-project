# Java-client-project
Java client project using remote method invocation(RMI)
Introduction:
This is a simple Rmi(Java Remote Method Invocation) Client-Server Program that allow the
Client to query for the “first name” of a student and to receive the list of “last name” of student
with the same name. The Server will query a postgres database to receive the list of student to pass
to the Client.
Project setup:

➢ Database:
1. Import database cpe_545.pgsql by following the link:
2. Name of database:cpe_545
3. Localhost:5432
https://www.interserver.net/tips/kb/export-import-postgresql-database/

➢ Server side:
1. It is necessary set the database postgresql by changing username and password in
Implement,java.
String DB_URL = "jdbc:postgresql://localhost:5432/cpe_545";
String USER = "postgres";
String PASS = "manideep1116";
2. The Server is set up to work on localhost and local port, then it is not necessary
change the IP address in the code.

➢ Client side:
1. Take note of the Server machine’s IP address if operating in two different systems.
2. Open Implement.java and place the IP address in place of local host.
Server steps
• Change the Directory to the destination folder
• Compile all the java files

➢ Javac *.java
• Start the registry on the specific port

➢ start rmiregistry
• Start the Server Program

➢ java -cp .;postgresql-42.1.4.jar -Djava.security.policy=Client.policy Server
Client Steps
• Change the Directory to the destination folder(…\cpe545_project2\src)
• Compile all the java files

➢ Javac *.java
• Start the Client Program

➢ Java -Djava.security.policy=Client.policy Client
Guide to start simulation:
Open command prompt and follow server steps.
Open another command prompt and follow client steps.
Now the Client and the Server are ready to communicate.
Starting server:
Starting client:
After entering first name:
Note: the name of the student is Case Sensitive
