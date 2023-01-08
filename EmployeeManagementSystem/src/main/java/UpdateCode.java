

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


@WebServlet("/UpdateCode")
public class UpdateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCode() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Name=request.getParameter("uname");
		String Password=request.getParameter("psw");
		String Email=request.getParameter("Email");
		String Address=request.getParameter("Address");
		String MobileNumber=request.getParameter("MobileNumber");
	
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMAR","amar");
			PreparedStatement ps=con.prepareStatement ("update Register set Name=?,password=?,Email=?,Address=?,MobileNumber=? where Name=?");
			ps.setString(1,Name);
			ps.setString(2,Password);
			ps.setString(3,Email);
			ps.setString(4,Address);
			ps.setString(5,MobileNumber);
			
			ps.setString(6,Name);
			int i=ps.executeUpdate();
			out.print(i+"Record Updated");
			con.close();
		}
		catch(Exception ex)
		{
			out.println(ex);
		}
	}

}
