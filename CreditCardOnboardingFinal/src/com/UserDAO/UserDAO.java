package com.UserDAO;
import com.UserBean.*;
import java.util.*;
import java.util.stream.*;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.UserBean.*;
//import java.sql.DriverManager;
public class UserDAO
{
    private UserBean ob;
    private String fname;
    private String pwd;
    public UserDAO(UserBean ob)
    {
        this.ob=ob;
    }
    public UserDAO()
    {
        
    }
    public UserDAO(String fname, String pwd)
    {
        this.fname=fname;
        this.pwd=pwd;
    }
    public static Connection getcon() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cog","root","root");
        return con;
    }
    
    //user registration check
    public boolean check(Connection con, UserBean u) throws SQLException
    {
        Statement st=con.createStatement();
        String query="select * from past where uid='"+u.getUid()+"' and fname='"+u.getFname()+"' and lname='"+u.getLname()+"' and gend='"+u.getGender()+"'";
        ResultSet rs=st.executeQuery(query);
        if(rs.next())
            return true;
        else
            return false;
    }
    
    
    
    public boolean check(Connection con, String signid, String pwd, String type) throws SQLException
    {
        //to check if it is in database or not
                if(type.equals("exist"))
                {
                       Statement st=con.createStatement();
                                String query="select * from present where password='"+pwd+"' and signid='"+signid+"'";
                        ResultSet rs=st.executeQuery(query);
                        if(rs.next())
                            return true;
                        else
                            return false;
                }
                
                //to check if status yes or not
                else if(type.equals("status"))
                {
                                
                                Statement st=con.createStatement();
            String query="select * from present where password='"+pwd+"' and signid='"+signid+"'and status='yes'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
                return true;
            else
                return false;
                }
                
                //ans check
                else if(type.equals("ans"))
                {
                                
                                String ans=pwd;
                                Statement st=con.createStatement();
            String query="select * from present where ans='"+ans+"' and signid='"+signid+"'and status='yes'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
                return true;
            else
                return false;
                }
                else return false;
    }

    //
    public boolean check(Connection con, String lid) throws SQLException
    {
                Statement st=con.createStatement();
                String query="select * from present where signid='"+lid+"'";
                ResultSet rs=st.executeQuery(query);
                if(rs.next())
                                return false;
                else
                                return true;
    }
  
    
    public boolean insert(Connection con, UserBean ob,String gend) throws SQLException
    {
                //admin register form
        if(gend.equals("male"))
            gend="m";
        else if(gend.equals("female"))
               gend="f";
        else
            gend="o";
        PreparedStatement ps=con.prepareStatement("insert into past values(?,?,?,?,?)");
        ps.setString(1, ob.getFname());
        ps.setString(2, ob.getLname());
        ps.setString(3, gend);
        ps.setInt(4, ob.getAge());
        ps.setString(5,ob.getUid());
        int k=ps.executeUpdate();
        if(k>0)
            return true;
        else
            return false;
    }

    public static boolean insert(UserBean u) throws SQLException
    {
                //customer register form
    	boolean b=false;
    	try
    	{
        PreparedStatement ps=getcon().prepareStatement("insert into present(fname,lname,gend,age,cno,uid,password,status,accno,signid,ans) values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, u.getFname());
        ps.setString(2, u.getLname());
        ps.setString(3, u.getGender());
        ps.setInt(4, u.getAge());
        ps.setString(5, u.getContactno());
        ps.setString(6, u.getUid());
        ps.setString(7, u.getPassword());
        if(u.isStatus())
               ps.setString(8, "yes");
        else
               ps.setString(8, "no");
                ps.setString(9, u.getAccNo());
        ps.setString(10, u.getSignid());
        ps.setString(11, u.getAns());
        int k=ps.executeUpdate();
        if(k>0)
               b=true;
        else
            b=false;
    	}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
    	return b;

    }
    public boolean update(Connection con,String signid,String pass) throws SQLException
    {
                 PreparedStatement ps=con.prepareStatement("update present set password=? where signid=?");
                 ps.setString(1, pass);
                 ps.setString(2, signid);
                 int k=ps.executeUpdate();
                 if(k>0)
                 return true;
                 else
                                 return false;
                 
    }
    public String[] select(Connection con,String fname, String pwd) throws SQLException
    {
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from present where signid='"+fname+"' and password='"+pwd+"'");
                String s[]=new String[5];
                while(rs.next()) {
                
                s[0]=rs.getString("fname");
                s[1]=rs.getString("lname");
               s[2]=rs.getString("gend");
                if(s[2].equals("m"))
                                s[2]="male";
                else
                                s[2]="female";
                s[3]=rs.getString("cno");
                s[4]=rs.getString("accno");
                }
                return s;
    }
    public static ArrayList<UserBean> GetUserDetails()
    {
    	ArrayList<UserBean> list=new ArrayList<>();
    	try
    	{
    		Connection con=UserDAO.getcon();
    		PreparedStatement ps=con.prepareStatement("select * from present");
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			UserBean u=new UserBean();
    			u.setFname(rs.getString("fname"));
    			u.setLname(rs.getString("lname"));
    			u.setAge(rs.getInt("age"));
    			u.setGender(rs.getString("gend"));
    			u.setContactno(rs.getString("cno"));
    			u.setStatus(rs.getBoolean("status"));
    			u.setUid(rs.getString("uid"));
    			u.setSignid(rs.getString("signid"));
    			u.setPassword(rs.getString("password"));
    			u.setAccNo(rs.getString("fname"), rs.getString("lname"));
    			u.setContactno(rs.getString("cno"));
    			list.add(u);
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in Getting User Details "+e);
    	}
    	return list;
    	
    }
    public static int ValidateSignId(String signid,String uid)
    {
    	int s=0;
    	try
    	{
    		ArrayList<UserBean> list=UserDAO.GetUserDetails();
    		  		
    		for(UserBean u:list)
    		{
    			if(u.getSignid().equals(signid) && u.getUid().equals(uid)) 
    			{
    				s+=1;
    				break;
    			}    				
    		}    		
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in Validating Sign Id "+e);
    	}
    	return s;
    }
}

