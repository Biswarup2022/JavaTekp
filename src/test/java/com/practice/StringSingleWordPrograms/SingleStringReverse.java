package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class SingleStringReverse {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Word Here : ");
		String str = sc.next();
		String rev = "";
		for(int i = str.length()-1; i>=0; i--) {
			
//		Simple Approach to reverse a Single Word String			
			char ch = str.charAt(i);
//			System.out.print(ch);
			
//		Another Approach to reverse a Single Word String			
//			rev = rev+ch;	
			rev += str.charAt(i);
		}
		System.out.println("Your Reversed Word Is : "+rev);

//		Checking String is Palindrome or Not
		
		if(str.equalsIgnoreCase(rev)) {
			System.out.println("Your Given Word Is Palindrome ==>"+rev);
		}
		else
		System.out.println("Your Given Word Is NOT Palindrome ==>"+rev);
	}
}
