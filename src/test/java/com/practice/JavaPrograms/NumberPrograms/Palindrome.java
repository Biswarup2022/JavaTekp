package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int num = sc.nextInt();
		int rev = 0;
		int temp = num;
		while(num>0) {
			
			int d = num%10;
			rev = rev*10+d;
			num = num/10;
		}
		if(temp==rev) {
			System.out.println(num+" : It Is A Palindrome");
		}
		else
			System.out.println(num+" : NOT A Palindrome");
	}

}
