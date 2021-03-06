import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;



@WebServlet("/SalesbyDateGraph")

public class SalesbyDateGraph extends HttpServlet {
    static Connection conn = null;
    static String message;

    public static String getConnection()
{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/groceryhub","root","mausam123");							
	message="Successfull";
	return message;
	}
	catch(SQLException e)
	{
		message="unsuccessful";
		     return message;
	}
	catch(Exception e)
	{
		message=e.getMessage();
		return message;
	}
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  

                
                    try {
                        getConnection();
                        String getData = "SELECT purchaseDate, sum(distinct(orderTotal)) as totalSales FROM customerorders group by purchaseDate";
                        Statement statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery(getData);
                        JSONArray json = new JSONArray();

                        while(rs.next()){
                            JSONObject obj = new JSONObject();
                            obj.put("product_name", rs.getDate("purchaseDate"));
                            obj.put("product_sales", rs.getDouble("totalSales"));
                            json.put(obj);
                        }
                        
                            System.out.println(json);
                            String jsonSales = new Gson().toJson(json);
                            response.setContentType("application/JSON");
                            response.setCharacterEncoding("UTF-8");
                            response.getWriter().write(jsonSales);
                
                    } catch (Exception e) {
                        System.out.println(e);
                        //TODO: handle exception
                    }
                }
}
