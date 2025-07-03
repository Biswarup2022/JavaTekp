package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class PowerOfANumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int num = sc.nextInt();
		System.out.println("Enter the Power : ");
		int power = sc.nextInt();
		int prod = 1;
		for(int i = 1; i<=power; i++) {
			prod=prod*num;
		}
		System.out.println("Multiplication of The Number is : "+prod);
	}
}
