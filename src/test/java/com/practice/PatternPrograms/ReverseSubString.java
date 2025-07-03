package com.practice.PatternPrograms;

import java.util.Scanner;

public class ReverseSubString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String to Get Reverse SubString : ");
		String str = sc.next();
		str = new StringBuilder(str).reverse().toString();
		
		for(int i=0; i<=str.length(); i++) {
			System.out.println(str.substring(0,i));
		}
	}
}
