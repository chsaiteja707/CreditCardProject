package com.project;
import com.UserBean.*;
import java.util.*;
import com.UserBean.*;
import com.UserDAO.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import java.sql.Connection;
import java.sql.SQLException;
//user servlet
//check()
//insert1()
/**
* Servlet implementation class Servlet1
*/
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                response.getWriter().append("Served at: ").append(request.getContextPath());
                }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                	PrintWriter out=response.getWriter();
                               // doGet(request, response);
                                String uid=request.getParameter("uid");
                                String fn=request.getParameter("fname");
                                String ln=request.getParameter("lname");
                                String bc=request.getParameter("age");
                                int age=Integer.parseInt(bc);
                                String gend=request.getParameter("gender");
                                String signid=request.getParameter("signid");
                                
                                
                                
								if(UserDAO.ValidateSignId(signid, uid)>0)
								{
									out.println("<script>alert('Choose Another UserID or Aadhar Number')</script>");
									request.getRequestDispatcher("register.html").include(request, response);
								}
								else
								{
                                if(gend.equals("male"))
                                                gend="m";
                                else if(gend.equals("female"))
                                                gend="f";
                                else
                                                gend="o";
                                String cno=request.getParameter("number");     
                                String pwd=request.getParameter("pwd");
                                String ans=request.getParameter("ans");
                                try 
                                {
                                                UserBean u=new UserBean();
                                                u.setFname(fn);
                                                u.setLname(ln);
                                                u.setGender(gend);
                                                u.setAge(age);
                                                u.setContactno(cno);
                                                u.setUid(uid);
                                                u.setPassword(pwd);
                                                u.setAccNo(fn, ln);
                                                u.setSignid(signid);
                                                u.setAns(ans);
                                                UserDAO ud=new UserDAO(u);
                                                Connection con=UserDAO.getcon();
                                                if(ud.check(con, signid))
                                                {
                                                                if(ud.check(con, u))
                                                                {
                                                                                u.setStatus(true);
                                                                                if(ud.insert( u))
                                                                                {
                                                                                                response.sendRedirect("submission.html");        
                                                                                }                                                                              
                                                                }
                                                                else
                                                                {
                                                                                u.setStatus(false);
                                                                                ud.insert(u);
                                                                                response.sendRedirect("submission.html");        
                                                                }
                                                }
                                                else
                                                {
                                                                response.sendRedirect("register.html");
                                                }
                                } catch (ClassNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
								}
                }

}

