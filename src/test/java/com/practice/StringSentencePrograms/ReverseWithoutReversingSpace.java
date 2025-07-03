package com.practice.StringSentencePrograms;

import java.util.Scanner;

public class ReverseWithoutReversingSpace {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Sentence to Reverse : ");
		String line = sc.nextLine();
		
		String s1 = line.replace(" ", "");
		int index = s1.length()-1;
		
		for(int i=line.length()-1; i>=0; i--) {
			
			if(line.charAt(i) == ' ') {
				System.out.print(" ");
			}
			else
				System.out.print(s1.charAt(index--));
		}
	}
}
