package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class OccurenceOfAString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Word Here : ");
		String word = sc.next();
		System.out.println("Enter the Alphabet to Find Occurrence : ");
		char ch = sc.next().charAt(0);
		
		int count = 0;
		
		for(int i=0; i<word.length(); i++) {
			
			if(word.charAt(i) == ch) {
				count++;
			}
		}
		System.out.println("Your Alphabet : "+ch+" Is Repeating ==> "+count);
		
		if(count>1) {
			System.out.println(ch);
		}
	}
}
