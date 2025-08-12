package com.practice.StringSentencePrograms;

import java.util.Scanner;

public class ReverseWithoutReversingSpace {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Sentence to Reverse : ");
		String line = sc.nextLine();
		// input = this is java interview
		
		// output 1 = interview java is this (Reverse the Sequence Only)
		String[] st = line.split(" ");
		
		for(int i = st.length-1; i>=0; i--) {
			System.out.print(st[i]+" ");
		}

		System.out.println();	
		
		// output 2 = weivretni avaj si siht (Reverse the Sequence and Words too)
		char[] ch = line.toCharArray();
			for(int i = ch.length-1; i>=0; i--) {
				System.out.print(ch[i]);
		}
			
		System.out.println();	
		
		
		// output 3 = siht si avaj weivretni (Reverse the Words Only)
		String o = "";
		for(String s : st) {
			String r = "";
			
			for(int i = s.length()-1; i>=0; i--) {
				
				r+=s.charAt(i);
			}
			o += r+" ";
		}
		System.out.println(o);	
		
		
		/*
		 * 	String s1 = line.replace(" ", "");
				int index = s1.length()-1;
				
				for(int i=line.length()-1; i>=0; i--) {
					
					if(line.charAt(i) == ' ') {
						System.out.print(" ");
					}
					else
						System.out.print(s1.charAt(index--));
				
		 */
			
	}
}
