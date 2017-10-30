package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.Books;

public class BookDao {

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

	public Books getBook(String student){

		Connection con;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		Books bk = null;


		String sql = "SELECT * FROM BOOKS WHERE MID=?"; //PREPARED STATEMENT
		con = getConn();


		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, student);
			rs=ps.executeQuery(); //executeQuery는 select함수만 사용!!

			if(rs.next()){
				System.out.println("결과셋이 있음");
				bk = new Books();
				bk.setIsbn(rs.getString("isbn"));
				bk.setTitle(rs.getString("title"));
				bk.setWriter(rs.getString("writer"));
				bk.setContent(rs.getString("content"));
				bk.setImage(rs.getString("image"));
				bk.setDate(rs.getString("date"));
				bk.setState(rs.getString("state"));
				bk.setSeq(rs.getString("seq"));


			}

		} catch(SQLException e){
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
		return bk;

	}

	/*public Books findBook(String title){

		Connection con;
		PreparedStatement ps = null; 
		ResultSet rs = null;
		Books bk = null;


		String sql = "SELECT * FROM BOOKS WHERE TITLE LIKE ?"; //PREPARED STATEMENT
		con = getConn();


		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+title+"%");
			rs=ps.executeQuery(); //executeQuery는 select함수만 사용!!

			if(rs.next()){
				System.out.println("결과셋이 있음");
				bk = new Books();
				bk.setIsbn(rs.getString("isbn"));
				bk.setTitle(rs.getString("title"));
				bk.setWriter(rs.getString("writer"));
				bk.setContent(rs.getString("content"));
				bk.setImage(rs.getString("image"));
				bk.setDate(rs.getString("date"));
				bk.setState(rs.getString("state"));

			}

		} catch(SQLException e){
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
		return bk;

	}
*/


	public int addBook(Books m) {

		Connection con = null;
		PreparedStatement ps = null;
		int af = 0;

		String sql= "INSERT INTO BOOKS(isbn,title,writer,content,image,date,state,seq) VALUES(?,?,?,?,?,?,?,(SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM BOOKS))";
		con = getConn();

		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getIsbn());
			ps.setString(2, m.getTitle());
			ps.setString(3, m.getWriter());
			ps.setString(4, m.getContent());
			ps.setString(5, m.getImage());
			ps.setString(6, m.getDate());
			ps.setString(7, m.getState());
			

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


	public ArrayList<Books> allBook(int pg, String field, String query,String title){

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Books bk;
		ArrayList<Books> list = null;
		int startRN = 1 + (pg-1)*10;

		String sql = "SELECT * FROM (SELECT ROWNUM AS RN, N.* FROM (SELECT * FROM (SELECT * FROM BOOKS WHERE TITLE=?) WHERE "+field+" LIKE ? ORDER BY TO_NUMBER(SEQ) DESC)N) WHERE RN BETWEEN ? AND ?";
		con = getConn();
		//Member m = new Member();
		try{
			ps= con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, "%"+query+"%");
			ps.setInt(3, startRN);
			ps.setInt(4, startRN+10);
			
			//ps.setString(1, mid);
			rs= ps.executeQuery();
			list= new ArrayList<Books>();

			while(rs.next()){

				bk = new Books();
				bk.setIsbn(rs.getString("isbn"));
				bk.setTitle(rs.getString("title"));
				bk.setWriter(rs.getString("writer"));
				bk.setContent(rs.getString("content"));
				bk.setImage(rs.getString("image"));
				bk.setDate(rs.getString("pubdate"));
				bk.setState(rs.getString("state"));
				bk.setSeq(rs.getString("seq"));

				list.add(bk);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<Books> allBook(int pg, String field, String query){
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Books bk;
		ArrayList<Books> list = null;
		int startRN = 1 + (pg-1)*10;

		String sql = "SELECT * FROM (SELECT ROWNUM AS RN, N.* FROM (SELECT * FROM BOOKS WHERE "+field+" LIKE ? ORDER BY TO_NUMBER(SEQ) DESC)N) WHERE RN BETWEEN ? AND ?";
		con = getConn();
		//Member m = new Member();
		try{
			ps= con.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, startRN);
			ps.setInt(3, startRN+10);
			//ps.setString(1, mid);
			rs= ps.executeQuery();
			list= new ArrayList<Books>();

			while(rs.next()){

				bk = new Books();
				bk.setIsbn(rs.getString("isbn"));
				bk.setTitle(rs.getString("title"));
				bk.setWriter(rs.getString("writer"));
				bk.setContent(rs.getString("content"));
				bk.setImage(rs.getString("image"));
				bk.setDate(rs.getString("pubdate"));
				bk.setState(rs.getString("state"));
				bk.setSeq(rs.getString("seq"));

				list.add(bk);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속해제실패");
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int getSeqCount(String field, String query) {
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		String sql = "SELECT COUNT(SEQ) FROM BOOKS WHERE "+field+" LIKE ?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+query+"%");
			rs=ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
				System.out.println("count="+count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}