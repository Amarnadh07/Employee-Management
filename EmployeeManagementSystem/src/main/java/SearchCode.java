

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchCode
 */
@WebServlet("/SearchCode")
public class SearchCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Name=request.getParameter("uname");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AMAR","amar");
			PreparedStatement ps=con.prepareStatement ("select * from Register where Name = ?");
			ps.setString(1,Name);
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rss=rs.getMetaData();
			int n=rss.getColumnCount(); 
			out.print("<html><body><table border='1'>");

			for(int i=1;i<=n;i++)    
				
				out.println("<td> <font color=blue size=3> "+"<br>"+rss.getColumnName(i));
				
				out.println("<tr>");
				
				while(rs.next())
				{
				for(int i=1;i<=n;i++)
					
				out.println("<td><br> "+rs.getString(i));
				out.println("<tr>");
				}
				out.println("</table> </body> </html>");
		}
		
			catch(Exception ex)
			{
				out.print(ex);
			}

		
		
		
	
	}

}
