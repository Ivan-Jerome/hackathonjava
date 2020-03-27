package mock_test;

public class TempExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		String s1="1091 u0_a214      10 -10 4.5G 153M  68M S 64.5   2.7   4:11.01 com.cardfree.an+";
		String s2="1091 u0_a214      10 -10 4.5G 151M  68M S  143   2.6   4:15.79 com.cardfree.an+";
		String s3="1091 u0_a214      20   0 4.5G 167M  83M S 90.6   2.9   4:30.98 com.cardfree.an+";
		String s4="1091 u0_a214      20   0 4.5G 167M  83M S  100   2.9   4:31.36 com.cardfree.an+";
		System.out.println(s1);
		String[] sa1 = s1.split(" ");
		i=0;
		while(i<sa1.length)
		{
			System.out.printf("%d--> %s",i,sa1[i]);
			System.out.println();
			i=i+1;
		}
		System.out.println();
		System.out.println(s2);
		String[] sa2 = s2.split(" ");
		i=0;
		while(i<sa2.length)
		{
			System.out.printf("%d--> %s",i,sa2[i]);
			System.out.println();
			i=i+1;
		}
		System.out.println();
		System.out.println(s3);
		String[] sa3 = s3.split(" ");
		i=0;
		while(i<sa3.length)
		{
			System.out.printf("%d--> %s",i,sa3[i]);
			System.out.println();
			i=i+1;
		}
		System.out.println();
		System.out.println(s4);
		String[] sa4 = s4.split(" ");
		i=0;
		while(i<sa4.length)
		{
			System.out.printf("%d--> %s",i,sa4[i]);
			System.out.println();
			i=i+1;
		}
	}
}
