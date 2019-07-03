package application;

public interface EmpActions {
	//SERVLETS & HTML
	employees login(String email, String password);
	//View their Homepage
	void logout();

	//NORMAL FUNCTIONS

	void submitRequest(double AMOUNT, String PURPOSE, String SUBMITTEDDATE, String STATUS, int EMPLOYEE_ID);
	void viewRequests(int empId);

	void viewInformation(int empID);
	void updateInformation(int empID, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS);

	//Optional:
	void uploadImage();
	void sendEmail();
	void resetPassword(); //(via email?)
}