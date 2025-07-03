package com.practice.JavaPrograms.NumberPrograms;

import java.util.HashSet;
import java.util.Scanner;

public class PracticeSample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Word : ");
		String word = sc.next();
		
//		System.out.println("Enter Your SECOND Number : ");
//		int b = sc.nextInt();
		
		HashSet set = new HashSet();
		
		for(int i = 0; i<word.length(); i++) {
			
			set.add(word.charAt(i));
		}
		System.out.println(set);
	}
}
