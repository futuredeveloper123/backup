package backjoon1227;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int i=1; i<=T ;i++) {

			int N = sc.nextInt();
			int X = sc.nextInt();
			
			System.out.println("Case #"+i+": " + N +" + "+ X +" = "+ (N+X));
		}
		sc.close();
	}

}
