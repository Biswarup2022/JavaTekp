package genericUtility.Practice;

import java.util.Random;

public class GenerateRandomAlphaNumericNumber
{
	public static void main(String[] args)
	{
		/**
		 * To generate an alpha-nuemeric unique value first we have to specify the number of values
		 * then we have to store the alphabets in both case
		 */
		int n = 10;
		String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		/**
		 * Create StringBuilder size of Alpha-Numric Values
		 * Then we have to generate random numbers between 0 to Aplha-numeric variable length
		 */
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=n; i++)
		{
			int index = new Random().nextInt(alphaNum.length());
//			int index = (int)(alphaNum.length()*Math.random());
			
			// add character one by one in the end of sb
			sb.append(alphaNum.charAt(index));
		}
		
		System.out.println(sb);
	}
}
