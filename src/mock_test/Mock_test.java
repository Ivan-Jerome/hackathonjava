package mock_test;
import java.io.*;
import java.sql.*;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Mock_test {

	static String hint;
	public static void main(String[] args) throws IOException {
		int count = 0;
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		FileWriter fileWriter = new FileWriter("cpu_data.json");
//		pushing the data fetched from db to HMTL file
		PrintWriter printWriter = new PrintWriter("htmloutput.html");

//		writing the data to files - Starting of table before looping in the table
		printWriter.println("<table border=1>");
		printWriter.println("<caption>MAX AND AVERAGE VALUES OF TRANSACTION CPU DATA</caption>");
		printWriter.println("<tr><th>TRANSACTION NAME</th><th>AVERAGE CPU TIME</th><th>MAXIMUM CPU TIME</th></tr>");
		obj1.put("transaction name", "sample_transaction");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mockjava","root","kaushik22india");  
			Statement stmt=con.createStatement();
			File file = new File("C:\\Users\\skaus\\Desktop\\cognizant_project_software\\sample_input.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			float value;
			float average_value = 0,max_value=0;
			while ((st = br.readLine()) != null)
			{

				String[] array = st.split(" ");
	
				if (array[8].length()>0)
				{
					if (array[14].length()>0)
					{
						value = Float.parseFloat(array[14]);
					}
					else 
					{
						value= Float.parseFloat(array[15]);
					}	
				}
				else 
				{
					if (array[16].length()>0)
					{
						value = Float.parseFloat(array[16]);
					}
					else 
					{
						value= Float.parseFloat(array[17]);;
					}	
				}
				average_value = (average_value+value)/2;
				if (value > max_value)
				{
					max_value = value;
				}
				count++;
				hint =Integer.toString(count)+ "S";
				//System.out.print(hint);
				obj2.put(hint, value);
			}
			obj1.put("average", average_value);
			obj1.put("max", max_value);
			obj1.put("values",obj2);
			try {
				fileWriter.write(obj1.toJSONString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fileWriter.flush();
				fileWriter.close();
			}
			String sql="INSERT into data_value (transaction_name,average_value,max_value) values('sample_transaction','"+average_value+"','"+max_value+"')";
			//PreparedStatement pStmt = (PreparedStatement) connection.prepareStatement("INSERT into data_value (transaction_name,average_value,max_value) values('tname1',avgvar,maxvar)");
			stmt.executeUpdate(sql);
	        stmt = con.createStatement();
	        String sql1 = "SELECT * FROM data_value";
	        ResultSet rs = stmt.executeQuery(sql1);
		    while (rs.next()) 
		    {
		    	String transactionname = rs.getString(1);
				double average_value1 = rs.getDouble(2);
				double max_value1  = rs.getDouble(3);
				printWriter.println("<tr>" + "<td>" + transactionname + "</td>" + "<td>" + average_value1 + "</td>"+ "<td>" + max_value1 + "</td>" + "</tr>" + "\n");
		    }
		    printWriter.println("</table>");
		    printWriter.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			System.out.println(obj1);
		}
	}
		
}