package com.sist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.dao.MemberDao;
import com.sist.vo.Members;

public class MemberLoginProcController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      String pg = "1";
      if(request.getParameter("pg")!=null){
         pg = request.getParameter("pg");
      }
      
      String mid = request.getParameter("mid");
      String pwd = request.getParameter("pwd");
      
      MemberDao dao = new MemberDao();
      Members m = dao.getMember(mid);
      
      HttpSession session = request.getSession();
      
      if(m==null){ //���̵� ������
         System.out.println("(!)�������� �ʴ� ���̵��Դϴ�.");
//         response.sendRedirect("login.do?error=IDx"); 
         return "redirect:login.do?error=IDx";
         
      } else { //���̵� ������
         if(m.getPwd().equals(pwd)){
            System.out.println("(��)�α��� ����");
            request.getSession().setAttribute("mid", mid);
//            response.sendRedirect("welcomelogin.jsp?pg="+pg);
            return "redirect:MyPage.do?pg="+pg;

         } else {
            System.out.println("(!)��й�ȣ�� �ٽ� �Է����ּ���.");
//            response.sendRedirect("login.do?error=PWDx");
            return "redirect:MemberLogin.do?error=PWDx";
         }
      }
      
   }
}