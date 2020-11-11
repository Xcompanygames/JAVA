	import java.lang.Math;
	import java.util.Scanner;

public class Ex1 {


		
		public static int GCD_find (int x , int y) {
			if(x<y) {
				   x = x + y;
				   y = x - y;
				   x = x - y;		}
			
			while(x%y!=0) {
			x=x%y;
			if(x<y) {
				   x = x + y;
				   y = x - y;
				   x = x - y;
			}
			
			}

			int temp=1;

			for (int i = 2; i <= y ; i++) {
				boolean Bool_Finish=true;
				for (int j = 2;(j <= Math.sqrt(i) && Bool_Finish); j++) {
					if(i%j == 0) Bool_Finish=false;
				}
				
				if(Bool_Finish&&(x%i==0)&&(y%i==0))
				{
					temp = i;
				}
				
			}

			return temp;

		}
		
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);  
	        int num1 = in.nextInt();
	        int num2 = in.nextInt();
			System.out.println(GCD_find(num1, num2));

		}
	}