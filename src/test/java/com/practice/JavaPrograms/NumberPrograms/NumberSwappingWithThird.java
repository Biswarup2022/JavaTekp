package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class NumberSwappingWithThird {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Number : ");
		int a = sc.nextInt();
		System.out.println("Enter Second Number : ");
		int b = sc.nextInt();
		
		System.out.println("Before Swapping");
		System.out.println("First Number : "+a);
		System.out.println("Second Number : "+b);
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("After Swapping");
		System.out.println("First Number : "+a);
		System.out.println("Second Number : "+b);
		
	}
}
