package Jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registration() {
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
			String sql="insert into Registration(name,password) values(?,?)";
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
            ps.setString(2 ,password);
           // ps.setString(3, Email);
           ps.executeUpdate();
            PrintWriter out=response.getWriter();
            response.sendRedirect("reg.jsp");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

}
