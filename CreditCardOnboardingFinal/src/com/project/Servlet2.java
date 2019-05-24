package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserDAO.UserDAO;

/**
* Servlet implementation class Servlet2
*/
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    


                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
                {
                                // TODO Auto-generated method stub
                                //doGet(request, response);
                                                
                                                //System.out.println(choice);
                                                String signid=request.getParameter("signid");
                                                String pwd=request.getParameter("pwd");
                                                try 
                                                {
                                                                Connection con=UserDAO.getcon();
                                                                UserDAO obj=new UserDAO(signid, pwd);
                                                                
                                                                                if(obj.check(con, signid, pwd,"exist"))
                                                                                {
                                                                                                if(obj.check(con, signid, pwd,"status"))
                                                                                                {
                                                                                                                String m[]=obj.select(con,signid,pwd);
                                                                                                                HttpSession session=request.getSession();
                                                                                                                session.setAttribute("uname", m[0]);
                                                                                                                session.setAttribute("lname", m[1]);
                                                                                                                session.setAttribute("gen", m[2]);
                                                                                                                session.setAttribute("cno", m[3]);
                                                                                                                session.setAttribute("uid", m[4]);
                                                                                                      
                                                                                                                RequestDispatcher rd=request.getRequestDispatcher("sucess.jsp");
                                                                                                                rd.include(request,response);
                                                                                                }
                                                                                                else
                                                                                                response.sendRedirect("fail.html");
                                                                                }
                                                                                else
                                                                                                response.sendRedirect("mismatch.html");
                                                                
                                                                                                
                                                } 
                                                catch (ClassNotFoundException | SQLException e) 
                                                {
                                                                e.printStackTrace();
                                                }
                                }
                
                

}
