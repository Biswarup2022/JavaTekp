package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class NumberDivisibility {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number to Check : ");
		int num = sc.nextInt();
		if(num%3==0 && num%5==0) {
			System.out.println(num+" : Divisible By Both 3 & 5");
		}
		else if(num%3==0) {
			System.out.println(num+" : Only Divisible By 3");
		}
		else if (num%5==0) {
			System.out.println(num+" : Only Divisible By 5");			
		}
		else
			System.out.println(num+" : Can NOT Divisible By 3 & 5");
	}
}
