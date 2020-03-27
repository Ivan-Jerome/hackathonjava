package hackthon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//string1.equals(string2)
public class Temp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\skaus\\Desktop\\cognizant_project_software\\hackthon\\memory.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		int count=0;
		while ((st = br.readLine()) != null)
		{
			//System.out.println(st);
			st=st.trim();
			//System.out.println(st);
			String[] array = st.split(" ");
			/*int i=0;
			while(i<array.length)
			{
				System.out.printf("%d--> %s",i,array[i]);
				System.out.println();
				i=i+1;
			}
			System.out.println();*/
			if (array[0].equals("TOTAL:")) //array[0].equals("TOTAL:")
			{
				//System.out.println(st);
				System.out.println(array[3]);
				count=count+1;
			}
		}
		System.out.println(count);
	}

}
