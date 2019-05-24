package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UserDAO.UserDAO;

/**
* Servlet implementation class servlet5
*/
@WebServlet("/servlet5")
public class Servlet5 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                
                }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                doGet(request, response);
                                String choice=request.getParameter("ans");
//                                if(choice.equals("npass"))
//                                {
//                                                String signid=request.getParameter("signid");
//                                                String pass=request.getParameter("npass");
//                                                try {
//                                                                Connection con=UserDAO.getcon();
//                                                                UserDAO obj=new UserDAO();
//                                                                                if(obj.update(con, signid, pass))
//                                                                                                response.sendRedirect("submission.html");
//                                                                                else
//                                                                                                response.sendRedirect("fail.html");                         
//                                                                }
//                                                catch (ClassNotFoundException | SQLException e)
//                                                {
//                                                                // TODO Auto-generated catch block
//                                                                e.printStackTrace();
//                                                }
//                                                
//                                }
//                                else
//                                {
                                                String a=request.getParameter("signid");
                                                String b=request.getParameter("ans");
                                                try {
                                                                Connection con=UserDAO.getcon();
                                                                UserDAO obj=new UserDAO();
                                                                if(obj.check(con, a, b,"ans"))
                                                                {
                                                                                response.sendRedirect("changepassword.html");
                                                                }
                                                                else
                                                                                response.sendRedirect("invalid.html");
                                                                
                                                }
                                                catch (ClassNotFoundException | SQLException e)
                                                {
                                                                // TODO Auto-generated catch block
                                                                e.printStackTrace();
                                                }
                                }
                }


