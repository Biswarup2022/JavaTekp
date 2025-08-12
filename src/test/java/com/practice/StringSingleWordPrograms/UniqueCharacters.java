package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

import org.testng.annotations.Test;

public class UniqueCharacters {

	@Test
	public void uniqueCharacters() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here to Check : ");
		String s = sc.nextLine();
		
		for(int i = 0; i<s.length()-1; i++) {
			
			char c = s.charAt(i);
			
			int a = s.indexOf(c); // returns the index of the first occurrence of character c.

			int b = s.lastIndexOf(c); // returns the index of the last occurrence of character c.
			
			// If both are equal, it means the character occurs only once — hence, it's unique.
			if(a == b) {
				
				System.out.println(c + " ");
			}
		}
	}
	
	@Test
	public void countOccurenece() {
		
		String s = "javaseleniumpythonselenium";
		String t = "java";
		int count = s.split(t, -1).length-1;
		
		System.out.println(t+" REPEATING ==> "+count);
		
	}
}
