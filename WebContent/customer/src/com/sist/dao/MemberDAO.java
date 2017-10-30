package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.sist.vo.Member;


public class MemberDAO {
	
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user="MEMBER";
		String pwd="1111";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속 실패, 계정과 비밀번호를 확인하세요.");
			e.printStackTrace();
		}
		return con;
	}

	//조회
	public Member getMember(String mid) {
		
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m=null;
		
		String sql = "SELECT * FROM MEMBER WHERE MID=?";
		con = getConn();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setBirthday(rs.getString("birthday"));
				m.setIsLunar(rs.getString("isLunar"));
				m.setPhone(rs.getString("phone"));
				m.setHabit(rs.getString("habit"));
				m.setRegDate(rs.getString("regDate"));
			}
		} catch (SQLException e) {
			System.out.println("회원정보 조회중 오류 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제 실패");
				e.printStackTrace();
			}
		}
		
		return m;
	}

	public int addMember(Member m) {
		
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "INSERT INTO MEMBER(MID,PWD,NAME,GENDER,AGE,BIRTHDAY,PHONE,HABIT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getGender());
			ps.setInt(5, m.getAge());
			ps.setString(6, m.getBirthday());
			//ps.setString(7, m.getIsLunar());
			ps.setString(7, m.getPhone());
			ps.setString(8, m.getHabit());
			
			af = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원가입 중 오류발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		return af;
	}

	public int updateMember(Member m) {
		
		Connection con;
		PreparedStatement ps=null;
		int af = 0;
		
		String sql = "UPDATE MEMBER SET PWD=?, NAME=?, GENDER=?, AGE=?, BIRTHDAY=?, PHONE=? HABIT=?"
				+ "WHERE MID=?";
		con = getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getPwd());
			ps.setString(2, m.getName());
			ps.setString(3, m.getGender());
			ps.setInt(4, m.getAge());
			ps.setString(5, m.getBirthday());
			//ps.setString(6, m.getIsLunar());
			ps.setString(6, m.getPhone());
			ps.setString(7, m.getHabit());
			ps.setString(8, m.getMid());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원정보수정 중 오류발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		return af;
		
	}

	public int delMember(Member member) {
		
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		
		String sql = "DELETE MEMBER WHERE MID=?";
		con = getConn();
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원탈퇴 중 오류발생");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		return af;
	}

	
	public ArrayList<Member> checkMember() {
		
		Connection con;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Member> mList = null;
		Member m = null;
		String sql = "SELECT * FROM MEMBER";
		con = getConn();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			mList = new ArrayList<Member>();
			while(rs.next()) {
				m=new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setBirthday(rs.getString("birthday"));
				//m.setIsLunar(rs.getString("isLunar"));
				m.setPhone(rs.getString("phone"));
				m.setHabit(rs.getString("habit"));
				m.setRegDate(rs.getString("regDate"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			System.out.println("회원전체조회 중 오류발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제 실패");
				e.printStackTrace();
			}
		}
		return mList;
	}
	
	
	
	
}
