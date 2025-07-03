package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String : ");
		String s = sc.next();
		
//		String s = "Hello";
		String res = "";
		for(int i = s.length()-1; i>=0; i--) {
			res = res+s.charAt(i);
		}
		System.out.println(res);
	}
}
