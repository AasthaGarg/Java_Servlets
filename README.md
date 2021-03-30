### Topics Covered

#### Topic 1: Servlets - Overview
 
##### Assignment 1:
Create a servlet with lifecycle methods that uses a loop to output an HTML table with 25 rows 
and 3 columns. For instance, each row could contain “RowX, Col1”, “RowX Col2”, and “RowX 
Col3”, where X is the current row number.
##### Assignment 2:
Write a Servlet program with lifecycle methods to get a Welcome reply from the server. <br/>
Note:- Create a HTML page to submit Name. Once user Submit the Name, Server should 
respond “Good Morning/Good Afternoon/Good evening” based on the Current time.

#### Topic 2: Servlets – Form Data

##### Assignment 1:
Write a servlet program to validate username and password. if Login is successful redirect to 
appropriate home page else response with appropriate error Message.<br/>
Assumption: - Login Page and User Table exists
##### Assignment 2:
Write a Servlet program to validate a Login. Assume there are two types of users (Admin and 
Employee). Appropriate Home page should be displayed after successful Login. In addition to 
that, display the appropriate error page for the invalid Login.<br/>
Note:-<br/>
i) Create a Users table with 3 Columns (username, password, Usertype). Usertype value is 
“A” for Admin and “E” for Employee. <br/>
ii) Design a Login Page with the Client side validations.in addition to that design Admin 
Homepage and Employee Home Page with some static Message to indicate a 
homepage.<br/>
##### Assignment 3:
Modify the Admin Home page for Admin user (Assignment 2) with the following Options to 
Add Training program and Delete Training program.<br/>
Add Training<br/>
Delete Training<br/>
Add Training: - When user clicks the Add Training, appropriate page should be open to add 
Training details like TrainingID, TrainingName, Startdate, EndDate, TrainingMode, 
BusinisessUnit, ContactpersonID. <br/>
Delete Training: - when user click this link, appropriate page should open to select the training 
program to be deleted.<br/>
Note:- Crete a table to add Training Details like TrainingID, TrainingName, Start Date, 
EndDate, TrainingMode, BusinisessUnit, ContactpersonID.

#### Topic 3: Servlets - Client Request, Server Response, HTTP Status Codes, Servlet Chaining

##### Assignment 1:
Create a servlet that forwards the request to one of three different servlet pages, depending on the 
value of the operation request parameter. Say if input is <10 then page 1 or greater than 10 and 
less than 99 then page 2 otherwise error page 3.
##### Assignment 2:
Write a servlet program to read Database connection information from web.xml File by using 
ServletConfig and ServletContext Methods.<br/>
Assumption :- Login Page and User Table exists<br/>

#### Topic 4: Servlets - Cookies Handling, Session Tracking, Page Redirect, Exceptions

##### Assignment 1:
Write a Servlet to do the following.<br/>
a) Accept username & password from login.html file & set or create cookies for it.<br/>
b) Retrieve these set of cookies to validate both the field from login table.<br/>
##### Assignment 2:
Create a Servlet that recognizes first time visitor to web application and responds by saying 
"Welcome to new user" otherwise “welcome back”<br/>
##### Assignment 3: 
Create a Servlet that uses hidden form fields session tracking mechanism, to keep per-client 
access counts.Sensitivity: Internal & Restricted<br/>
##### Assignment 4:
Write a servlet program to validate Login and store User information in Session. From the home
page of the user click the link to get Employee Salary Details.<br/>
Assumption: Login Page, Home page, User table and salary table exits
