package application;

public interface AdminActions {
	//SERVLETS AND HTML

	admin login(String email, String password);
	//View their Homepage
	void logout();

	//NORMAL FUNCTIONS

	void approve(int reID);
	void deny(int reID);
	void viewAllRequests();
	void viewRequests(int empID);
	void viewAllEmployees();

	//Optional:
	void viewImages();
	void registerEmployees(String EMPLOYEETYPE, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS);
	// this will send them an email with login info eventually
}