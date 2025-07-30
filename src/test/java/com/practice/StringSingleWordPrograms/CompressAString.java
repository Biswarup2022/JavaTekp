package com.practice.StringSingleWordPrograms;

import java.util.Scanner;

public class CompressAString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String st = sc.next();
		
		StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < st.length(); i++) {
        	
            if (i + 1 < st.length() && st.charAt(i) == st.charAt(i + 1)) {
               
            	count++;
            }
            
            else {
                result.append(st.charAt(i));
                result.append(count);
                count = 1;
            }
        }
        System.out.println("Original: " + st);
        System.out.println("Compressed: " + result.toString());
	}
}
