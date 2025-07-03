package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class ExpandAString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String st = sc.next();
		
		for(int i=0; i<st.length(); i=i+2) {
			int count = st.charAt(i+1)-48;
			char ch = st.charAt(i);
			
			for(int j=1; j<=count; j++) {
				System.out.println(ch);
			}
		}
	}
}
