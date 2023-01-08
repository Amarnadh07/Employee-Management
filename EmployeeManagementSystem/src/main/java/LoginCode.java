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


@WebServlet("/LoginCode")
public class LoginCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginCode() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String password= request.getParameter("psw");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMAR","amar");
			PreparedStatement ps = con.prepareStatement("select * from Register where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);	
			ResultSet rs=ps.executeQuery();
			if(rs.next())
		{
				response.sendRedirect("emphome.html");
		}
			else
			  {
				out.print("Invalid username or password");
			  }
				con.close();
			  }
			catch(Exception ex)
			 {
				out.print(ex);
			 }
		}
	}

