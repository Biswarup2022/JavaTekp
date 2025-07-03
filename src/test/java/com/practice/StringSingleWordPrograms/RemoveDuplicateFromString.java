package com.practice.StringSingleWordPrograms;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateFromString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String word = sc.next();
		
		LinkedHashSet set = new LinkedHashSet();
		
		for(int i=0; i<word.length(); i++) {
			
			set.add(word.charAt(i));
		}
		System.out.println(set);
	}
}
