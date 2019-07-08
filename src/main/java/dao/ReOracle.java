package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import application.admin;
import application.employees;
import application.reimbursements;
import application.users;
import util.ConnectionUtil;

@SuppressWarnings("unused")
public class ReOracle implements ReDao {
	private static final Logger log = LogManager.getLogger(ReOracle.class);
	private static final DecimalFormat df = new DecimalFormat();
	
	public List<users> getAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		List<users> list;
		
		try {			
			String sql = "select * from ALLEMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			list = new LinkedList<users>();
			
			while(rs.next()){
				if(rs.getString("EMPLOYEETYPE").equals("ADMIN"))
				{
					list.add(new admin(rs.getInt("EMPLOYEEID"), rs.getString("EMPLOYEETYPE"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"),  rs.getString("ADDRESS"), rs.getString("STARTDATE"), rs.getString("STATUS")));
				}
				else if(rs.getString("EMPLOYEETYPE").equals("EMPLOYEE"))
				{
					list.add(new employees(rs.getInt("EMPLOYEEID"), rs.getString("EMPLOYEETYPE"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"),  rs.getString("ADDRESS"), rs.getString("STARTDATE"), rs.getString("STATUS")));
				}
			}
		}catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return list;
	}
	public employees getInfo(int empID) throws Exception{
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		employees tmp;
		
		try {
			String sql = "select * from ALLEMPLOYEES WHERE EMPLOYEEID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				return new employees(rs.getInt("EMPLOYEEID"), rs.getString("EMPLOYEETYPE"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"),  rs.getString("ADDRESS"), rs.getString("STARTDATE"), rs.getString("STATUS"));
			}
		}catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return null;
	}
	public List<reimbursements> getAllRe() throws Exception
	{
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		List<reimbursements> list;
		
		try {			
			String sql = "select * from REIMBURSEMENTS WHERE STATUS != 'SUBMITTED'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			list = new LinkedList<reimbursements>();
			
			while(rs.next()){
				list.add(new reimbursements(rs.getInt("REQUESTID"), rs.getDouble("AMOUNT"), rs.getString("PURPOSE"), rs.getString("SUBMITTEDDATE"), rs.getString("STATUS"), rs.getInt("EMPLOYEE_ID")));
			}
		}catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return list;
	}
	public List<reimbursements> getAllUnRe() throws Exception
	{
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		List<reimbursements> list;
		
		try {			
			String sql = "select * from REIMBURSEMENTS WHERE STATUS = 'SUBMITTED'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			list = new LinkedList<reimbursements>();
			
			while(rs.next()){
				list.add(new reimbursements(rs.getInt("REQUESTID"), rs.getDouble("AMOUNT"), rs.getString("PURPOSE"), rs.getString("SUBMITTEDDATE"), rs.getString("STATUS"), rs.getInt("EMPLOYEE_ID")));
			}
		}catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return list;
	}
	public List<reimbursements> getRe(int empID) throws Exception
	{
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		List<reimbursements> list;
		
		try {			
			String sql = "select * from REIMBURSEMENTS WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			
			list = new LinkedList<reimbursements>();
			
			while(rs.next()){
				list.add(new reimbursements(rs.getInt("REQUESTID"), rs.getDouble("AMOUNT"), rs.getString("PURPOSE"), rs.getString("SUBMITTEDDATE"), rs.getString("STATUS"), rs.getInt("EMPLOYEE_ID")));
			}
		}catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return list;
	}
	public employees loginE(String userName, String password) throws Exception{
		employees tmp = new employees();
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			String sql = "select * from ALLEMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(rs.getString("EMAIL").equals(userName) && rs.getString("PASSWORD").equals(password))
				{
					if(rs.getString("EMPLOYEETYPE").equals("EMPLOYEE"))
					{
						tmp = new employees(rs.getInt("EMPLOYEEID"), rs.getString("EMPLOYEETYPE"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"),  rs.getString("ADDRESS"), rs.getString("STARTDATE"), rs.getString("STATUS"));
					}
				}
			}
		} catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return tmp;
	}
	
	public admin loginA(String userName, String password) throws Exception{
		admin tmp = new admin();
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			String sql = "select * from ALLEMPLOYEES";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(rs.getString("EMAIL").equals(userName) && rs.getString("PASSWORD").equals(password))
				{
					if(rs.getString("EMPLOYEETYPE").equals("ADMIN"))
					{
						tmp = new admin(rs.getInt("EMPLOYEEID"), rs.getString("EMPLOYEETYPE"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), rs.getString("EMAIL"), rs.getString("PASSWORD"),  rs.getString("ADDRESS"), rs.getString("STARTDATE"), rs.getString("STATUS"));
					}
				}
			}
		} catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
		return tmp;
	}
	public void insertEmp(String EMPLOYEETYPE, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS) throws Exception {
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			String sql = "call create_employee(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement ps = con.prepareCall(sql);
			ps.registerOutParameter(1, Types.INTEGER);
			ps.setString(2, EMPLOYEETYPE);
			ps.setString(3, FIRSTNAME);
			ps.setString(4, LASTNAME);
			ps.setString(5, EMAIL);
			ps.setString(6, PASSWORD);
			ps.setString(7, ADDRESS);
			ps.setString(8, STARTDATE);
			ps.setString(9, STATUS);
			ps.executeUpdate();
			int id = ps.getInt(1);
			System.out.println("Successfully Added to database: ");
			System.out.print("New Employee Account number is: ");
			System.out.println(id);
		} catch (SQLException e){
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
	}
	public void updateEmp(int empID, String FIRSTNAME, String LASTNAME, String EMAIL, String PASSWORD, String ADDRESS, String STARTDATE, String STATUS) throws Exception {
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			String sql = "UPDATE ALLEMPLOYEES SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PASSWORD = ?, ADDRESS = ?, STARTDATE = ?, STATUS = ? WHERE EMPLOYEEID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, FIRSTNAME);
			ps.setString(2, LASTNAME);
			ps.setString(3, EMAIL);
			ps.setString(4, PASSWORD);
			ps.setString(5, ADDRESS);
			ps.setString(6, STARTDATE);
			ps.setString(7, STATUS);
			ps.setInt(8, empID);
			ps.executeUpdate();
			System.out.println("Successfully Updated");
		} catch (SQLException e){
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
	}
	public void insertRe(double AMOUNT, String PURPOSE, String SUBMITTEDDATE, String STATUS, int EMPLOYEE_ID) throws Exception {
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			STATUS = "SUBMITTED";
			String sql = "call create_request(?, ?, ?, ?, ?, ?)";
			CallableStatement ps = con.prepareCall(sql);
			ps.registerOutParameter(1, Types.INTEGER);
			ps.setDouble(2, AMOUNT);
			ps.setString(3, PURPOSE);
			ps.setString(4, SUBMITTEDDATE);
			ps.setString(5, STATUS);
			ps.setInt(6, EMPLOYEE_ID);
			ps.executeUpdate();
			int id = ps.getInt(1);
			System.out.println("Successfully Added to database: ");
			System.out.print("Your request number is: ");
			System.out.println(id);
		} catch (SQLException e){
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
	}
	public void approve(int reId)throws Exception
	{
		Connection con = ConnectionUtil.getConnection();
		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			String sql = "UPDATE REIMBURSEMENTS SET STATUS = 'APPROVED' WHERE REQUESTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reId);
			ps.executeUpdate();
			System.out.println("Successfully Approved");
		} catch (SQLException e){
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}
	}
	public void deny(int reId)throws Exception
	{
		Connection con = ConnectionUtil.getConnection();
		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}
		try {
			String sql = "UPDATE REIMBURSEMENTS SET STATUS = 'DENIED' WHERE REQUESTID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, reId);
			ps.executeUpdate();
			System.out.println("Successfully Approved");
		} catch (SQLException e){
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}	
	}
}