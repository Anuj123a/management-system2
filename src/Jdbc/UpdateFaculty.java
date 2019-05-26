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


@WebServlet("/UpdateFaculty")
public class UpdateFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdateFaculty() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			
			String Name=request.getParameter("F.name");
			String Course=request.getParameter("course");
			String ID=request.getParameter("ID");
			String Mobile=request.getParameter("mobile");
			String Email=request.getParameter("Email");
			String Add=request.getParameter("Add");
		    String sql="update  Faculty set name=?,Course=?,Mobile=?,Email=?,Add=?  where ID='"+ID+"'";
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
			PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1 ,Name);
            ps.setString(2, Course);
            ps.setString(3 ,Mobile);
            ps.setString(4 ,Email);
            ps.setString(5, Add);
           ps.executeUpdate();
            PrintWriter out=response.getWriter();
            out.println("update successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}

}
