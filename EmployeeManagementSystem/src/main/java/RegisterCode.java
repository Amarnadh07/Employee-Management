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

@WebServlet("/RegisterCode")
public class RegisterCode extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public RegisterCode() {
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
		String Gender=request.getParameter("gender");
		String Address=request.getParameter("Address");
		String MobileNumber=request.getParameter("MobileNumber");
		String State=request.getParameter("State");
		String Country=request.getParameter("Country");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMAR","amar");
			PreparedStatement ps=con.prepareStatement ("insert into Register values (?,?,?,?,?,?,?,?)");
			ps.setString(1,Name);
			ps.setString(2,Password);
			ps.setString(3,Email);
			ps.setString(4,Gender);
			ps.setString(5,Address);
			ps.setString(6,MobileNumber);
			ps.setString(7, State);
			ps.setString(8, Country);	
			int i=ps.executeUpdate();
			out.print(i+"New Record Is Inserted Succesfully Account created");
			con.close();
		}
			catch(Exception ex)
			{
				out.print(ex);
			}

	
	
	
	}

}