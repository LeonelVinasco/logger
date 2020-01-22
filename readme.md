<h3> Comments</h3>

a) At the beggining of the code, in the importation list,
   some lines can be removed by importing the complete libraries:
   java.util.*, java.sql.*, java.util.logging.

b)  Only using throwables methos, makes things a bit more difficult when the developer is identifying where an error occurs.
    The lines of database connection, file creation and handling, should be handled with a try/catch block with their respective exceptions. Im not trying to say that programming should be exception oriented, i just say that there are cases where it could make the code clearer.

c) The IO files operations are not handled with try/catch and their
   respective exceptions.

d) The database configuration and its operations should be completely isolated
   from the class. Using a persistence framework could be a good idea.

e) The l String variable is concatenated along three methods, but its not used. I supose the idea is to log the entire l variable, and not only the messageText var.

f) Variable names are not telling me what they are. t and l should have names that help others developers to understand their purpose in the code.

g) There are repeated conditionals which sentences can be grouped.

h) POO characteristics and components could be used to develop a cleaner code. 

i) The main method dont use auxiliary methods to keep its code shorter and understandable.

j) There is a variable called initialized, which is not used. Its not static as the other ones, and i really dont understand the purpose of it.

k) If its not necessary to keep the variables shared with other classes, the private static variables could be non static and getters and setters can be created to access them if necessary.

l) The use of other package for the database access and handling is necesary. 

m) When the messageText is trimmed. Its not assigned again to the variable. In my tests the method trim() dont modifies the same String, it returns a new trimmed string.

n) The database name is missing at the connection sentence.

o) The databasename is missing in the parameters map. 

p) The level of the log can be severity in any option. 
