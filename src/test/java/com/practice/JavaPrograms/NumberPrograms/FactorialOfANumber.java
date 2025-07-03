package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class FactorialOfANumber {

	public static void main(String[] args) {
		
		System.out.println("Enter the Number to Get Factorial : ");
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long f = 1;
		for(long i = 1; i<=num; i++) {
			f*=i;
		}
		System.out.println(f+" : It is The Factorial Number");
	}
}
