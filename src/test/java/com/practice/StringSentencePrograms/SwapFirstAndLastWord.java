package com.practice.StringSentencePrograms;

import java.util.Arrays;
import java.util.Scanner;

public class SwapFirstAndLastWord {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Sentence to Swap First and Last Word : ");
		String line = sc.nextLine();
		
		String[] str = line.split(" ");
		String temp = str[str.length-1];
		str[str.length-1] = str[0];
		str[0] = temp;
		System.out.println(Arrays.toString(str));
	}
}
