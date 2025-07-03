package com.practice.ArrayPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class ShiftZerosToLeft {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the LENGTH of Array : ");
		int n = sc.nextInt();
		int[]a = new int[n];
		
		for(int i=0; i<a.length; i++) {
						
			System.out.println("Enter Your Numbers With Zero : ");
			a[i]=sc.nextInt();
		}
		
		System.out.println(n+" : It Is the LENGTH You Want");
		System.out.println("Your Created Array is : "+Arrays.toString(a));
	
//	int[] a = {0,0,1,2,3,0,0,4,0};
	int[] b = new int[a.length];
	int index = b.length-1;
	for(int i = a.length-1; i>=0; i--) {
		
		if(a[i]!=0) {
			
			b[index--]=a[i];
		}
	}
	System.out.println("Shifting ZEROS to Left : "+Arrays.toString(b));
	}
}

