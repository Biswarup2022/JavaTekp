package com.practice.JavaPrograms.NumberPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PracticeSample extends Thread {
	
	public void run() {
		for(int i = 'a'; i<='z'; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
//		PracticeSample sample = new PracticeSample();
//		sample.start();
//		for(int i = 0; i<25; i++) {
//			System.out.println(i);
//		}
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Rows You Want : ");
		int l = s.nextInt();
		  int rows = 5; // number of rows
	        int num = 1;  // starting number

	        for(int i = 1; i <= l; i++) {
	            for(int j = 1; j <= i; j++) {
	                System.out.print(num + " ");
	                num++;
	            }
	            System.out.println(); // move to next line
	        }
	}
	
}
		

