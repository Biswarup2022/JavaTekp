package com.practice.StringSentencePrograms;

import java.util.Scanner;

public class RemoveVowelsFromAString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Sentence Here : ");
		String s = sc.nextLine();
		String line = s.toUpperCase().replaceAll("[AEIOU]", "");
		System.out.println(line);
		
	}
}
