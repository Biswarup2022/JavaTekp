package com.practice.PatternPrograms;

import java.util.Scanner;

public class PyramidPattern2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of ROWS You Want : ");
		int rows = sc.nextInt();
//		for rows creation
		for(int i=1; i<=rows; i++) {
			
//			for space creation
			for(int j=1; j<=2*(rows-i); j++) {
				System.out.print(" ");
			}
			
//			for increasing numbers	
			for(int k=1; k<=i; k++) {
				System.out.print(k+" ");				
			}
			
//				for decreasing numbers	
			for(int l=i-1; l>=1; l--) {
				System.out.print(l+" ");
			}
			System.out.println();
		}
	}
}
