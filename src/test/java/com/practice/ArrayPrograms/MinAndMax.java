package com.practice.ArrayPrograms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MinAndMax {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the LENGTH of the ARRAY : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<a.length;i++)
		{
			System.out.println("Pass Your Number : ");
			a[i]=sc.nextInt();
		}
		System.out.println(n+" : It is the Length You Want");
		System.out.println("So Your Created Array is : "+Arrays.toString(a));
		
		int max = a[0];
		int min = a[0];
		for(int i = 0; i<a.length; i++) {
			if(a[i]>max) {
				max = a[i];
			}
			if(a[i]<min) {
				min = a[i];
			}
		}
		System.out.println("Maximum Number from Given Array : "+max);
		System.out.println("Minimum Number from Given Array : "+min);
	}
}
