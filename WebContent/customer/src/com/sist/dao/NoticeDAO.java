package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.Notice;

public class NoticeDAO {
	
	public Connection getConn() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "MEMBER";
		String pwd = "1111";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ӽ���, ������� ��й�ȣ�� Ȯ���ϼ���.");
			e.printStackTrace();
		}
		return con;
	}
	
	//�����Լ�
	public int getSeqCount(String field, String query) {
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		String sql = "SELECT COUNT(SEQ) FROM NOTICE WHERE "+field+" LIKE ?";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count;
	}
	//����Ʈ ��ü ��ȸ-�˻�
	public ArrayList<Notice> allNotices(int pg, String field, String query) {
		Connection con;
		//Statement st = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Notice> nList = null;
		int startRN = 1 + (pg-1)*10;
		
		String sql = "SELECT * FROM (SELECT ROWNUM AS RN, N.* FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY TO_NUMBER(SEQ) DESC)N) WHERE RN BETWEEN ? AND ?";
		con=getConn();
		try {
			//st=con.createStatement();
			ps=con.prepareStatement(sql);
			//1. ���������� ���� �Խñ� �� ���� (ex.10)-> 2. ����¡�� ���̴� ������ ���� ����(ex.5)
			ps.setString(1, "%"+query+"%");
			ps.setInt(2, startRN);
			ps.setInt(3, startRN+10);
			rs=ps.executeQuery();
			
			nList = new ArrayList<>();
			while(rs.next()) {
				Notice nt = new Notice();
				nt.setSeq(rs.getString("seq"));
				nt.setTitle(rs.getString("title"));
				nt.setWriter(rs.getString("writer"));
				nt.setRegdate(rs.getString("regdate"));
				nt.setHit(rs.getInt("hit"));
				
				nList.add(nt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�Խ��� ��ü��ȸ �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				//st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return nList;
	}
	
	//���ϴ� �Խ��� ��ȸ
	public Notice getNotices(String seq) {
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Notice n = null;
		String sql = "SELECT * FROM NOTICE WHERE SEQ=? ORDER BY TO_NUMBER(SEQ) DESC";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, seq);
			rs=ps.executeQuery();
			if(rs.next()){
				n=new Notice();
				n.setSeq(rs.getString("seq"));
				n.setTitle(rs.getString("title"));
				n.setWriter(rs.getString("writer"));
				n.setContent(rs.getString("content"));
				n.setRegdate(rs.getString("regdate"));
				n.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�Խ��� ��ȸ �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return n;
	}
	
	//�Խ��� �߰�
	public int addNotices(Notice n, String mid) {
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		
		System.out.println(mid);
		
		String sql = "INSERT INTO NOTICE (SEQ, TITLE, WRITER, CONTENT, REGDATE) VALUES ((SELECT NVL(MAX(TO_NUMBER(SEQ)),0)+1 FROM NOTICE), ?, ?, ?, SYSDATE)";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, n.getTitle());
			ps.setString(2, mid);
			ps.setString(3, n.getContent());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�Խ��� �߰� �� �����߻�");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������������");
				e.printStackTrace();
			}
		}
		return af;
	}
	
	//�Խ��� ����
	public int updateNotices(Notice n) {
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=? WHERE SEQ=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, n.getTitle());
			ps.setString(2, n.getContent());
			ps.setString(3, n.getSeq());
			af = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�Խ��� ���� �� �����߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("���ӽ���");
				e.printStackTrace();
			}
		}
		return af;
		
	}
	
	//�Խñ� ����
	public int deleteNotice(Notice n) {
		Connection con;
		PreparedStatement ps = null;
		int af = 0;
		String sql = "DELETE NOTICE WHERE SEQ=?";
		con=getConn();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, n.getSeq());
			af=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�Խñ� ������ �����߻�");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("�������� ����");
				e.printStackTrace();
			}
		}
		
		return af;
	}
}
