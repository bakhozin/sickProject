package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.Members;

public class MemberDao {

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user= "MyProject";
	String pwd= "111111";

	public Connection getConn(){

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("접속 실패, 계정명과 비밀번호를 확인하세요");
			e.printStackTrace();
		}

		return con;
	}

	public Members getMember(String mid){

		Connection con;
		PreparedStatement ps=null;
		ResultSet rs= null;
		Members m=null;

		String sql="SELECT * FROM MEMBERS WHERE MID=?";
		con=getConn();

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();

			if(rs.next()){
				System.out.println("결과셋이 있다");
				m= new Members();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setAddress(rs.getString("address"));
				m.setGender(rs.getString("gender"));
				m.setStatus(rs.getString("status"));
				m.setAge(rs.getInt("age"));
				m.setBalance(rs.getInt("balance"));
			}
		}catch(SQLException e){
			System.out.println("회원정보 조회중 오류발생");
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				ps.close();
				con.close();
			} catch(SQLException e) {
				System.out.println("접속해제에 실패");
				e.printStackTrace();
			}		
		}
		return m;

	}	


	public int addMember(Members m) {

		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;

		String sql= "INSERT INTO MEMBERS(mid,pwd,name,address,gender,status,age,balance) VALUES(?,?,?,?,?,?,?,?)";
		con = getConn();

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getGender());
			ps.setString(6, m.getStatus());
			ps.setInt(7, m.getAge());
			ps.setInt(8, m.getBalance());

			af = ps.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			try{
				ps.close();
				con.close();
			} catch(SQLException e) {
				System.out.println("접속해제에 실패");
				e.printStackTrace();
			}
		}
		return af;
	}

	public int delMember(String mid){

		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;


		//String sql2='';
		String sql1= "DELETE FROM DEALS WHERE FACCOUNTNUM IN(SELECT ACCOUNTNUM FROM ACCOUNTS WHERE OWNER=?)";
		String sql2 = "DELETE FROM ACCOUNTS WHERE OWNER=?";
		String sql3= "DELETE FROM MEMBERS WHERE MID=?";
		con = getConn();

		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql1);
			ps.setString(1, mid);			
			af = af+ ps.executeUpdate();

			ps= con.prepareStatement(sql2);
			ps.setString(1, mid);
			af = af+ ps.executeUpdate();

			ps= con.prepareStatement(sql3);
			ps.setString(1, mid);
			af = af+ ps.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			try{
				ps.close();
				con.close();
			} catch(SQLException e) {
				System.out.println("접속해제에 실패");
				e.printStackTrace();
			}
		}
		return af;
	}

	public int updateMember(String pwd, String address, String mid) {

		Connection con = null;
		PreparedStatement ps = null;

		int af = 0;

		String sql= "UPDATE MEMBERS SET PWD=?, ADDRESS=? WHERE MID=?";
		con = getConn();

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, address);
			ps.setString(3, mid);

			af = ps.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			try{
				ps.close();
				con.close();
			} catch(SQLException e) {
				System.out.println("접속해제에 실패");
				e.printStackTrace();
			}
		}

		return af;
	}

	public ArrayList<Members> allMembers(){

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Members m;
		ArrayList<Members> memberList = null;

		String sql = "SELECT * FROM MEMBERS";
		con = getConn();

		try{
			st= con.createStatement();
			rs= st.executeQuery(sql);
			memberList= new ArrayList<Members>();

			while(rs.next()){

				m= new Members();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setAddress(rs.getString("address"));
				m.setGender(rs.getString("gender"));
				m.setStatus(rs.getString("status"));
				m.setAge(rs.getInt("age"));
				m.setBalance(rs.getInt("balance"));

				memberList.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return memberList;
	}

}	


