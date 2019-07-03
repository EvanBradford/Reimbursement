package application;

import java.util.List;

import dao.ReService;

public class admin extends users implements AdminActions{
	private static final long serialVersionUID = -5312758439517622438L;

	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public admin(int employeeId, String employeeType, String firstname, String lastname, String email, String password,
			String address, String startDate, String status) {
		super(employeeId, employeeType, firstname, lastname, email, password, address, startDate, status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getEmployeeId() {
		// TODO Auto-generated method stub
		return super.getEmployeeId();
	}

	@Override
	public void setEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		super.setEmployeeId(employeeId);
	}

	@Override
	public String getEmployeeType() {
		// TODO Auto-generated method stub
		return super.getEmployeeType();
	}

	@Override
	public void setEmployeeType(String employeeType) {
		// TODO Auto-generated method stub
		super.setEmployeeType(employeeType);
	}

	@Override
	public String getFirstname() {
		// TODO Auto-generated method stub
		return super.getFirstname();
	}

	@Override
	public void setFirstname(String firstname) {
		// TODO Auto-generated method stub
		super.setFirstname(firstname);
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return super.getLastname();
	}

	@Override
	public void setLastname(String lastname) {
		// TODO Auto-generated method stub
		super.setLastname(lastname);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}

	@Override
	public String getStartDate() {
		// TODO Auto-generated method stub
		return super.getStartDate();
	}

	@Override
	public void setStartDate(String startDate) {
		// TODO Auto-generated method stub
		super.setStartDate(startDate);
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return super.getStatus();
	}

	@Override
	public void setStatus(String status) {
		// TODO Auto-generated method stub
		super.setStatus(status);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "admin [employeeId=" + employeeId + ", employeeType=" + employeeType + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", startDate=" + startDate + ", status=" + status + "]";
	}

	
	//START ACTUAL FUNCTIONS END AUTOGEN
	
	
	@Override
	public admin login(String email, String password)
	{
		// TODO Auto-generated method stub
		admin tmp = new admin();
		try
		{		
			tmp = ReService.loginA(email, password);
		}
		catch (Exception e)
		{
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
	public void approve(int reID) {
		try {
			ReService.approve(reID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deny(int reID) {
		// TODO Auto-generated method stub
		try {
			ReService.deny(reID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllRequests() {
		// TODO Auto-generated method stub
		List<reimbursements> list;
		try {		
			list = ReService.getAllRe();
		} catch (Exception e) {
			System.out.println("Opps.. (^_^)");
			return;
		}
		System.out.println(list);
		return;
	}

	@Override
	public void viewRequests(int empID) {
		// TODO Auto-generated method stub
		List<reimbursements> list;
		try {		
			list = ReService.getRe(empID);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println(list);
		return;
	}

	@Override
	public void viewAllEmployees() {
		// TODO Auto-generated method stub
		List<users> list;
		try {
			list = ReService.getAllAccounts();
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println(list);
		return;
	}
	
	//OPTIONAL

	@Override
	public void viewImages() {
		// TODO Auto-generated method stub
	}

	@Override
	public void registerEmployees(String EMPLOYEETYPE, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS) {
		// TODO Auto-generated method stub
		try {		
			ReService.insertEmp(EMPLOYEETYPE, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ADDRESS, STARTDATE, STATUS);
		} catch (Exception e) {
			System.out.println("Oops.. (^_^)");
			return;
		}
		System.out.println("Account Created");
		return;
	}
}