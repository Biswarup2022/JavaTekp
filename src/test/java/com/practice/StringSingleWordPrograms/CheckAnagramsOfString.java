package com.practice.StringSingleWordPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class CheckAnagramsOfString {

//	If Two Strings are having all the same alphabets in different order then those are called Anagrams (Race==Care)
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your First String Here : ");
		String first = sc.next();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Your Second String Here : ");
		String second = s.next();
		
		if(first.length() == second.length()) {
			
			char[] ch1 = first.toLowerCase().toCharArray();
			char[] ch2 = second.toLowerCase().toCharArray();
			
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			
			if(Arrays.equals(ch1, ch2)) {
				
				System.out.println(first+" AND "+second+" ==>> These are Anagrams");
			}
			else
				System.out.println(first+" AND "+second+" ==>> These are NOT Anagrams");
				
		}
		else
			System.out.println(first+" AND "+second+" ==>> These are NOT Anagrams");
	}
}
