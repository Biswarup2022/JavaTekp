package com.practice.ArrayPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the LENGTH of the ARRAY : ");
		int a = sc.nextInt();
		int[] b = new int[a];
		
		for(int i=0; i<b.length; i++) {
			
			System.out.println("Enter Your Number : ");
			b[i] = sc.nextInt();
		}
		System.out.println(a+" : It Is The Length You Want");
		System.out.println("Your Created ARRAY is : "+Arrays.toString(b));
		System.out.println("Enter the Number of Rotation : ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int temp = b[0];
			for(int j=0; j<b.length-1; j++) {
				b[j] = b[j+1];
			}
			b[b.length-1]=temp;
		}
		System.out.println("After 1st Rotation : "+Arrays.toString(b));
	}
}
