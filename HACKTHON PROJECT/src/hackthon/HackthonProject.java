package hackthon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import org.json.simple.JSONObject;
import java.io.FileWriter;
public class HackthonProject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		float total_value=0,avg_value,value,max_value=0;
		String hint,st;
		JSONObject obj2 = new JSONObject();
		File file = new File("C:\\Users\\skaus\\Desktop\\cognizant_project_software\\hackthon\\memory.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int count=0; 
		while ((st = br.readLine()) != null)
		{
			st=st.trim();
			String[] array = st.split(" ");
			if (array[0].equals("TOTAL")) //array[0].equals("TOTAL:") //to eliminate the second row
			{
				value = Float.parseFloat(array[3])/1024; //converting the KB String value to MB Float value
				//System.out.print(value);System.out.print("--");
				total_value = total_value+value;
				if (value > max_value)
				{
					max_value = value;
				}
				count=count+1;
				hint =Integer.toString(count)+ "S";
				obj2.put(hint, value); //pushing the memory MB values to obj2 json object
			}
		}
		avg_value=total_value/count; //finding avg value
		//System.out.println();
		String Smax_value=String.valueOf(max_value)+" MB"; //adding the "MB" to max value
		String Savg_value=String.valueOf(avg_value)+" MB"; //adding the "MB" to avg value
		JSONObject obj1 = new JSONObject();
		//System.out.println(max_value);
		//System.out.println(avg_value);
		//System.out.println(count);
		obj1.put("average", Savg_value);  //pushing the average memory MB values to obj1 json object
		obj1.put("max", Smax_value);  //pushing the maximum memory MB values to obj1 json object
		obj1.put("values",obj2);  //pushing the obj2 json to obj1 json
		System.out.println(obj1);
		FileWriter fileWriter = new FileWriter("memory_data.json");
		try {
			fileWriter.write(obj1.toJSONString()); //wirting to a external json file
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileWriter.flush();
			fileWriter.close();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hackthon","root","kaushik22india");  
			Statement stmt=con.createStatement();
			String sql="INSERT into memoryvalue (maximum_value,average_value) values('"+max_value+"','"+avg_value+"')";//writing to db
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
