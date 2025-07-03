package com.practice.ArrayPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class SecondMaximum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the LENGTH of the ARRAY : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<a.length;i++)
		{
			System.out.println("Enter Your Number : ");
			a[i]=sc.nextInt();
		}
		System.out.println(n+" : It is the Length You Want");
		System.out.println("So Your Created Array is : "+Arrays.toString(a));
		
		int max = Integer.MIN_VALUE; //a[0]
		int smax = Integer.MIN_VALUE;
		for(int i = 0; i<a.length; i++) {
			
			if(a[i]>max) {
				smax = max;
				max = a[i];
			}
			else if(a[i]>smax && a[i]!=max) {
				smax = a[i];
			}
		}
		
		System.out.println("Highest Number from Given Array : "+max);
		System.out.println("Second Highest Number from Given Array : "+smax);
	}
}
