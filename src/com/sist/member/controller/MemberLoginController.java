package com.sist.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;

public class MemberLoginController implements Controller{

   
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      String pg = "1";
      if(request.getParameter("pg")!=null){
         pg = request.getParameter("pg");
      }
      
      String error = request.getParameter("error"); //error라는 key값을 받아서 변수에 넣어줌
      if(error != null && !error.equals("")){ //null이 아니거나 빈문자가 아니면
         if(error.equals("IDx")){
            error ="ID error";
         }else if(error.equals("PWDx")){
            error = "PWD error";
         }
      }
      
      request.setAttribute("pg", pg);
      request.setAttribute("error", error);
      
//      request.getRequestDispatcher("login.jsp").forward(request, response);
      return "MemberLogin.jsp";
   }
}