package application;

public class system {

	public static void main(String[] args) {
		System.out.println("WIP, this is for testing only");
		
//		admin ad = new admin();
//		ad.viewAllEmployees();
//		ad.viewAllRequests();
//		ad.viewRequests(21);
//		String EMPLOYEETYPE = "EMPLOYEE";
//		String FIRSTNAME = "Hank";
//		String LASTNAME = "Hillard";
		String EMAIL = "propane@email.com";
		String PASSWORD = "12345";
//		String ADDRESS = "1234 Strickland Propane";
//		String STARTDATE = "2/24/2005";
//		String STATUS = "ACTIVE";
//		ad.registerEmployees(EMPLOYEETYPE, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, STARTDATE, STATUS);
//		
		employees emp = new employees();
		emp = emp.login(EMAIL, PASSWORD);
		
		emp.viewInformation(emp.getEmployeeId());
		emp.viewRequests(emp.getEmployeeId());
		
//		emp.updateInformation(emp.getEmployeeId(), FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, STARTDATE, STATUS);
//		
//		emp.viewInformation(emp.getEmployeeId());
//		emp.viewRequests(emp.getEmployeeId());
//		
//		System.out.println(emp);
//		double AMOUNT = 9999.99;
//		String PURPOSE = "Y2K";
//		String SUBMITTEDDATE = "11/27/1999";
//		String STATUS = "SUBMITTED";
//		int EMPLOYEE_ID = emp.getEmployeeId();
//	
//		emp.submitRequest(AMOUNT, PURPOSE, SUBMITTEDDATE, STATUS, EMPLOYEE_ID);
	}
}