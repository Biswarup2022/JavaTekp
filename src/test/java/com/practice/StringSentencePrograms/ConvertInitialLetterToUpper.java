package com.practice.StringSentencePrograms;

import java.util.Scanner;

public class ConvertInitialLetterToUpper {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Sentence to Reverse : ");
		String line = sc.nextLine();
		
		String[] str = line.split(" ");
		
		for(int i=0; i<str.length; i++) {
			
			String s = str[i];
			System.out.print(Character.toUpperCase(s.charAt(0))+s.substring(1)+" ");
		}
	}
}
