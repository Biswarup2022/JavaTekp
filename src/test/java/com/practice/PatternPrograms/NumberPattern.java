package com.practice.PatternPrograms;

import java.util.Scanner;

import org.testng.annotations.Test;

public class NumberPattern {

	@Test
	public void numberPattern() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Rows You Want : ");
		int num = sc.nextInt();
		int n = 1;
		for(int i = 1; i<=num; i++) {
			for(int j = 1; j<=i; j++) {
				System.out.print(n+" ");
				n++;
			}
			System.out.println();
		}
	}
	
	@Test
	public void reverseNumberPattern() {
		
		int n = 5;        // number of rows
        int num = 15;     // starting number

        for (int i = 0; i < n; i++) {
            // Print leading spaces (3 spaces per level for formatting)
            for (int s = 0; s < i; s++) {
                System.out.print("   ");
            }

            // Print numbers
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%3d", num--);
            }

            System.out.println();
        }
		
	}
}
