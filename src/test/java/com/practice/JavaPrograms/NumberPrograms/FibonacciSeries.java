package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 1;
		System.out.println("Enter The Number Limit To Get The Fibonacci Series : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 0; i<num; i++) {
			System.out.println(a+" ");
			int next = a+b;
			a = b;
			b = next;
		}
	}
}
