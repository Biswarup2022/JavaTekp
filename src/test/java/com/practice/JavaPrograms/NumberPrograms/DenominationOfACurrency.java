package com.practice.JavaPrograms.NumberPrograms;

import java.util.Scanner;

public class DenominationOfACurrency {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Amount : ");
		int value = sc.nextInt();
		
		int[] notes = {2000,500,200,100,50,20,10,5,2,1};
		int [] b = new int[notes.length];
		
		for(int i=0; i<notes.length; i++) {
			b[i] = value/notes[i];
//			System.out.println(notes[i]+":"+b);
			value = value%notes[i];
		}
		
		System.out.println("Your Denominations For Given Value : ");
		
		for(int i=0; i<notes.length; i++) {
			
			if(b[i]>0) {
				
				System.out.println(notes[i] +" ==> "+ b[i]);
			}
		}	
	}
}
