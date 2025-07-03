package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class CompressAString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String st = sc.next();
		int count = 1;
		
		for(int i=0; i<st.length()-1; i++) {
			
			if(st.charAt(i) == st.charAt(i+1)) {
				count++;
			}
			else
				System.out.print(st.charAt(i)+""+count);
				count = 1;
		}
		System.out.print(st.charAt(st.length()-1)+""+count);
	}
}
