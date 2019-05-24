package com.project;
import com.AdminBean.*;
import com.AdminDAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet7
 */
@WebServlet("/servlet7")
public class Servlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet7() {
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
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		AdminDAO obx=new AdminDAO();
		ArrayList<AdminBean> ob=null;
		try {
			ob = obx.getUsers();
			
			int k=obx.count(ob);
			HttpSession session=request.getSession();
			session.setAttribute("list", ob);
			session.setAttribute("count", k);
			request.getRequestDispatcher("view.jsp").forward(request, response);
			/*PrintWriter out=response.getWriter();
			out.print("<table style='width=100%; border:1px'");
			out.print("<tr><th>Enter & Click</th><th>Product Id</th><th>Product Name</th><th>Category</th><th>Description</th><th>Price</th><th>Quantity</th></tr>");
			for(AdminBean pp:ob)
			{
				out.print("<tr><td><input type='text' name='quantity' style='width:30px;'><a href='StoreProducts.jsp?pid="+pp.getId()+"'><button style='width:50px;'>Add</button></a></td><td>"+pp.getId()+"</td><td>"+pp.getName()+"</td><td>"+pp.getCategory()+"</td><td>"+pp.getDescription()+"</td><td>"+pp.getPrice()+"</td><td>"+pp.getQuantity()+"</td></tr>");
			}
			out.print("</table>");
			out.println("<br><br><a href='HomePage.html' target='_parent'><button>HOMEPAGE</button></a>");*/
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
