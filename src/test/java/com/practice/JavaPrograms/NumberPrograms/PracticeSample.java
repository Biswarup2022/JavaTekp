package com.practice.JavaPrograms.NumberPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PracticeSample {
	
	public static void main(String[] args) {
		
		int a = 0;
		int b = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number You Want : ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.println(a+ " ");
			int next = a+b;
			a = b;
			b = next;
		}

	}      
}
		

