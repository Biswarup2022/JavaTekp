package com.practice.StringSingleWordPrograms;

import java.util.ArrayList;
import java.util.Scanner;

public class BalancedAString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your String Here : ");
		String s = sc.next();
		
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<s.length(); i++) {
			if((list.size()>0)
						&& ((s.charAt(i) ==')' && list.get(list.size()-1) =='(')
						|| (s.charAt(i) ==']') && list.get(list.size()-1) =='[')
						|| (s.charAt(i) =='}') && list.get(list.size()-1) =='{') {
				
				list.remove(list.get(list.size()-1));	
				}
				else
					list.add(s.charAt(i));
		}
		if(list.isEmpty()) {
			System.out.println(s+" : Your Given String is Balanaced");
		}
		else
			System.out.println(s+" : Your Given String is NOT Balanaced");			
	}
}
