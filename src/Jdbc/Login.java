package Jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Login() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String name=request.getParameter("user");
			String password=request.getParameter("password");
			//String Email=request.getParameter("Email");
			 String dbname=null;
			 String dbpassword=null;
			//String dbEmail=null;
			String sql="select * from Registration where name=? and password=?";
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
            ps.setString(2 ,password);
           // ps.setString(3, Email);
            ResultSet rs=ps.executeQuery();
            PrintWriter out=response.getWriter();
            while(rs.next())
            {
            	dbname=rs.getString("name");
            	dbpassword=rs.getString("password");
            	//dbEmail=rs.getString("Email");
            }
            if(name.equals(dbname)&&password.equals(dbpassword))
            {
            	response.sendRedirect("welcome.jsp");
            }
            else
            {
            	response.sendRedirect("login.jsp");
            }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
