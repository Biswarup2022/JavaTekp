package com.practice.StringSingleWordPrograms;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveDuplicateFromString {
	
	
	public static String removeDuplicates(String input) {
        // Convert string to character array
        char[] chars = input.toCharArray();
        int length = chars.length;

        // Index to place the next unique character
        int index = 0;

        for (int i = 0; i < length; i++) {
            boolean isDuplicate = false;

            // Check if chars[i] has appeared before in chars[0...index-1]
            for (int j = 0; j < index; j++) {
                if (chars[i] == chars[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not duplicate, place it in the current index
            if (!isDuplicate) {
                chars[index] = chars[i];
                index++;
            }
        }

        // Create result string from unique characters
        return new String(chars, 0, index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
    }
	
	
/*
 * 
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
 */
}
