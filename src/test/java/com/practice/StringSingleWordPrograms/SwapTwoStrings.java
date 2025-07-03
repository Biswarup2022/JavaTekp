package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class SwapTwoStrings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Word : ");
		String first = sc.next();

		System.out.println("Enter the Second Word : ");
		String second = sc.next();
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<< BEFORE SWAPPING >>>>>>>>>>>>>>>>>>");
		System.out.println("Your First Word is : "+first);
		System.out.println("Your Second Word is : "+second);
		
		first = first + second;
		second = first.substring(0, first.length()-second.length());
		first = first.substring(second.length());

		System.out.println("<<<<<<<<<<<<<<<<<<<<< AFTER SWAPPING >>>>>>>>>>>>>>>>>>");
		System.out.println("Your First Word is : "+first);
		System.out.println("Your Second Word is : "+second);
	}
}
