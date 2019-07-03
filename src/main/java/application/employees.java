package application;

import java.util.List;

import dao.ReService;

public class employees extends users implements EmpActions{

	/**
	 * 
	 */
	private static final long serialVersionUID = -850410748123462791L;

	public employees() {
		super();
	}

	public employees(int employeeId, String employeeType, String firstname, String lastname, String email,
			String password, String address, String startDate, String status) {
		super(employeeId, employeeType, firstname, lastname, email, password, address, startDate, status);
	}

	@Override
	public int getEmployeeId() {
		return super.getEmployeeId();
	}

	@Override
	public void setEmployeeId(int employeeId) {
		super.setEmployeeId(employeeId);
	}

	@Override
	public String getEmployeeType() {
		return super.getEmployeeType();
	}

	@Override
	public void setEmployeeType(String employeeType) {
		super.setEmployeeType(employeeType);
	}

	@Override
	public String getFirstname() {
		return super.getFirstname();
	}

	@Override
	public void setFirstname(String firstname) {
		super.setFirstname(firstname);
	}

	@Override
	public String getLastname() {
		return super.getLastname();
	}

	@Override
	public void setLastname(String lastname) {
		super.setLastname(lastname);
	}

	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}

	@Override
	public String getAddress() {
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		super.setAddress(address);
	}

	@Override
	public String getStartDate() {
		return super.getStartDate();
	}

	@Override
	public void setStartDate(String startDate) {
		super.setStartDate(startDate);
	}

	@Override
	public String getStatus() {
		return super.getStatus();
	}

	@Override
	public void setStatus(String status) {
		super.setStatus(status);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "employees [employeeId=" + employeeId + ", employeeType=" + employeeType + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", startDate=" + startDate + ", status=" + status + "]";
	}
	
	
	//START ACTUAL FUNCTIONS END AUTOGEN
	

	@Override
	public employees login(String email, String password) {
		employees tmp = new employees();
		try {		
			tmp = ReService.loginE(email, password);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return null;
		}
		return tmp;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void submitRequest(double AMOUNT, String PURPOSE, String SUBMITTEDDATE, String STATUS, int EMPLOYEE_ID) {
		try {
			ReService.insertRe(AMOUNT, PURPOSE, SUBMITTEDDATE, STATUS, EMPLOYEE_ID);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println("Account Created");
		return;
	}
	@Override
	public void viewRequests(int empId) {
		List<reimbursements> list;
		try {		
			list = ReService.getRe(empId);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println(list);
		return;
	}

	@Override
	public void viewInformation(int empID) {
		employees tmp = new employees();
		try {
			tmp = ReService.getInfo(empID);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println(tmp);
		return;
	}

	@Override
	public void updateInformation(int empID, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS) {
		try {		
			ReService.updateEmp(empID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, STARTDATE, STATUS);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println("Account Created");
		return;
	}
	
	//OPTIONAL

	@Override
	public void uploadImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPassword() {
		// TODO Auto-generated method stub
		
	}
}