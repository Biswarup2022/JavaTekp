package com.practice.StringSentencePrograms;

import java.util.Scanner;

public class ReverseTheSequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Sentence to Reverse : ");
		String line = sc.nextLine();
		
//		split the string as per spaces
		String[] str = line.split(" ");
		
		for(int i=str.length-1; i>=0; i--) {
			System.out.print(str[i]+" ");
		}
	}
}
