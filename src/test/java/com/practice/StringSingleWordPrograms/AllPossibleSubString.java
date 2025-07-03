package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class AllPossibleSubString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String str = sc.next();
		int len = 0;
		String s = "";
		
		System.out.println("All Possible Substring of Your Given Input is : ");

		for(int i=0; i<str.length(); i++) {
			
			for(int j=i+1; j<=str.length(); j++) {
				
				String st = str.substring(i, j);
//				System.out.println(st);
				System.out.println(st+" ");
				
//				To check the given string is palindrome or not
//				String sr = new StringBuilder(st).reverse().toString();
//				if(st.equals(sr) && len<st.length()) {
//					len = st.length();
//					s = st;
//				}
			}
		}
//		System.out.println(s);
	}
}
