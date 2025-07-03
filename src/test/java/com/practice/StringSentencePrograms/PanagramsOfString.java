package com.practice.StringSentencePrograms;

import java.util.HashSet;
import java.util.Scanner;

public class PanagramsOfString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Sentence to Reverse : ");
		String s = sc.nextLine();
		
		String s1 = s.toLowerCase();
		HashSet set = new HashSet();
		
		for(int i=0; i<s1.length(); i++) {
			char ch = s1.charAt(i);
			if(Character.isAlphabetic(ch)) {
				set.add(ch);
			}
		}
		if(set.size() == 26) {
			System.out.println(s+" ==> It Is Panagram ");
		}
		else
			System.out.println(s+" ==> It Is NOT Panagram ");
			
	}
}
