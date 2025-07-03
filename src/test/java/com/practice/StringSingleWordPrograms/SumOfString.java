package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class SumOfString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String to Get SUM : ");
		String str = sc.next();
		int sum = 0;
		
		for(int i = 0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if((ch>='0' && ch<='9') || (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
//				48 has given to balance the ASCII Value
				sum = sum+ch-48;
			}
		}
		System.out.println("The SUM of the Numbers Present in the String : "+sum);
	}
}
