This is a project from training to learn how to make servlets link up with a database. 
It allows employees to request reimbursement and the company to approve or deny those requests.
Below is the basic layout and planned functionality of the project

Class Employee

functions

SERVLETS & HTML

Login
View their Homepage
logout

NORMAL FUNCTIONS

submit reimbursement request
view their pending/resolved requests

view their information
Update their information

Optional:
Upload Image as Evidence
Recieve Email when resolved
Reset Password (via email?)

Class Admin

SERVLETS AND HTML

Login
View their Homepage
logout

NORMAL FUNCTIONS

approve/deny reimbursement requests
view all pending/resolved requests from all employees
view all request of a specific employee
view all employees

Optional:

View images uploaded as evidence by employees
Register New emplyees and send them an email with login info

DATABASE LAYOUT

TABLE EMPLOYEES
EMPLOYEEID EmployeeType FirstNAME Lastname email password phoneNumber address StartDate Status

TABLE REIMBURSEMENTS
REQUESTID Amount Purpose SubmittedDate Status (foreign key EMPLOYEEID)
