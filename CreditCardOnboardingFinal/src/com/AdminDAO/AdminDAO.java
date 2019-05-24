package com.AdminDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.AdminBean.*;
import com.UserBean.*;
import com.UserDAO.*;
public class AdminDAO {
	public ArrayList<AdminBean> getUsers() throws ClassNotFoundException, SQLException
	{
		ArrayList<AdminBean> ob=new ArrayList<AdminBean>();
		
		Connection con=UserDAO.getcon();
		PreparedStatement ps=con.prepareStatement("select fname,lname,uid,status from present");
		ResultSet rs=ps.executeQuery();		
		while(rs.next())
		{
			String a=rs.getString(1);
			String b=rs.getString(2);
			String c=rs.getString(3);
			String d=rs.getString(4);
			ob.add(new AdminBean(a, b, c, d));
		}
		return ob;
	}
	public static int count(ArrayList<AdminBean> al) throws SQLException
	{
		int count=0;

		for(AdminBean a:al)
			count++;
		return count;
		
	}

}
