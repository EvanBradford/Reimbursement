package dao;

import java.util.List;

import application.admin;
import application.employees;
import application.reimbursements;
import application.users;

public interface ReDao {
	List<users> getAll() throws Exception;
	employees getInfo(int empID) throws Exception;
	List<reimbursements> getAllRe() throws Exception;
	List<reimbursements> getRe(int empID) throws Exception;
	employees loginE(String email, String password) throws Exception;
	admin loginA(String email, String password) throws Exception;
	void insertEmp(String EMPLOYEETYPE, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS) throws Exception;
	void updateEmp(int empID, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS) throws Exception;
	void insertRe(double AMOUNT, String PURPOSE, String SUBMITTEDDATE, String STATUS, int EMPLOYEE_ID) throws Exception;
	void approve(int reId)throws Exception;
	void deny(int reId)throws Exception;
}