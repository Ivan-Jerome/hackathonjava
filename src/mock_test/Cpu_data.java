package mock_test;
import java.io.*;
import java.sql.*;
import org.json.simple.JSONObject;
public class mo {

	static String hint;
	public static void main(String[] args) throws IOException {
		int count = 0;
		JSONObject obj = new JSONObject();
		obj.put("transaction name", "sample_transaction");
		//System.out.println(obj);
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
				obj.put(hint, value);
			}
			System.out.printf("average value: %f\t max value: %f",average_value,max_value);
			System.out.println();
			obj.put("average", average_value);
			//System.out.println(obj);
			obj.put("max", max_value);
			//System.out.println(obj);
			String sql="INSERT into data_value (transaction_name,average_value,max_value) values('sample_transaction','"+average_value+"','"+max_value+"')";
			//PreparedStatement pStmt = (PreparedStatement) connection.prepareStatement("INSERT into data_value (transaction_name,average_value,max_value) values('tname1',avgvar,maxvar)");
			stmt.executeUpdate(sql);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			System.out.println(obj);
		}
	}
		
}

