package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		System.out.println("Enter Your Number : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean flag = true;
		if(num < 2) {
			
			flag=false;
		}
		else
		{
			for(int i = 2; i<num-1; i++)
			{
				if(num%i == 0)
				{
					flag = false;
					break;
				}			
			}
		}
		
		if(flag) {
			System.out.println(num+" : It Is A PRIME Number");
		}
		else
			System.out.println(num+" : NOT A Prime Number");
	}
}
