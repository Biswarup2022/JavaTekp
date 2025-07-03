package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class FindNumAlphaCharFromString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String str = sc.next();
		int numCount = 0, alphaCount = 0, charCount = 0;
		
		for(int i=0; i<str.length();i++) {
			
			char ch = str.charAt(i);
			
			if(ch>='0' && ch<='9') {
				numCount++;
			}				
				else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')) {
					alphaCount++;
				}
				else charCount++;
		}
		System.out.println("Numbers Present in The Given String : "+numCount);
		System.out.println("Alphabets Present in The Given String : "+alphaCount);
		System.out.println("Characters Present in The Given String : "+charCount);
	}
}
