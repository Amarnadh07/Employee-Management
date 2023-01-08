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


@WebServlet("/DeleteCode")
public class DeleteCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteCode() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
    	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("name");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMAR","amar");
			PreparedStatement ps=con.prepareStatement ("Delete register where Name=?");
			ps.setString(1,Name);
			int i=ps.executeUpdate();
			out.print(i+"Record deleted");
			con.close();
		}
			catch(Exception ex)
			{
				out.print(ex);
			}
    }

}
