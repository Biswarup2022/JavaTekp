package com.practice.PatternPrograms;

import java.util.Scanner;

public class TrianglePattern6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number Of Rows You Want : ");
		int rows = sc.nextInt();
		
//		int rows = 4;
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=rows; j++) {
				
				if(i+j >= rows+1) {
					System.out.print(j+" ");
				}
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
