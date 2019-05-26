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


@WebServlet("/UpdateStu")
public class UpdateStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateStu() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String Course=request.getParameter("course");
			String Timing=request.getParameter("Timing");
			String Name=request.getParameter("S.name");
			String ID=request.getParameter("ID");
			String Mobile=request.getParameter("mobile");
			String Email=request.getParameter("Email");
			String Add=request.getParameter("Add");
		    String sql="update  student set Course=?,Timing=?,name=?,Mobile=?,Email=?,Add=?  where ID='"+ID+"'";
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Course);
            ps.setString(2 ,Timing);
            ps.setString(3 ,Name);
            ps.setString(4 ,Mobile);
            ps.setString(5 ,Email);
            ps.setString(6, Add);
           ps.executeUpdate();
            PrintWriter out=response.getWriter();
            out.println("Updated successfully");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
