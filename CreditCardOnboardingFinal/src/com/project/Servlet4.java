package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UserBean.*;
import com.UserDAO.UserDAO;
/**
* Servlet implementation class Servlet4
*/
@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
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
                                doGet(request, response);
                                String fname=request.getParameter("fname");
                                String lname=request.getParameter("lname");
                                String gend=request.getParameter("gender");
                                String age1=request.getParameter("age");
                                int age=Integer.parseInt(age1);
                                String uid=request.getParameter("uid");
                                UserBean ob=new UserBean(fname, lname,gend ,age, uid);
                                UserDAO obj=new UserDAO(ob);
                                try {
                                                Connection con=obj.getcon();
                                                String gender=ob.getGender();
                                                if(obj.insert(con,ob,gender))
                                                {
                                                                response.sendRedirect("adminchoice.html");
                                                }
                                } catch (ClassNotFoundException | SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                }

}
