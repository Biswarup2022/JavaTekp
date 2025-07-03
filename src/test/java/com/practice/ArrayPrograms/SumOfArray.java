package com.practice.ArrayPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Length of The First Array : ");
		System.out.println("======================================================");
		int x = sc.nextInt();
		int[] a = new int[x];
		for(int j=0; j<a.length; j++) {
			
			System.out.println("Enter Your Number : ");
			a[j] = sc.nextInt();
		}
		System.out.println(x+" : It Is The Length You Want");
		System.out.println("======================================================");
		System.out.println("Your Created Array Is : "+Arrays.toString(a));
		System.out.println("======================================================");
		System.out.println("======================================================");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter The Length of The Second Array : ");
		System.out.println("======================================================");
		int o = s.nextInt();
		int[] b = new int[o];
		for(int p=0; p<b.length; p++) {

			System.out.println("Enter Your Number For Second Array : ");
			b[p] = s.nextInt();
		}
		System.out.println(o+" : It Is The Length You Want For Second Array");
		System.out.println("======================================================");
		System.out.println("Your Created Array Is : "+Arrays.toString(b));
		System.out.println("======================================================");
		System.out.println("======================================================");
		
//		int[] a = {1,2,3,4};
//		int[] b = {4,5,6};
		int max = Math.max(a.length, b.length);
		int[] sum = new int[max];
		
		for(int i=0; i<max; i++) {
			
			if(i<a.length) {
				sum[i] += a[i]; 
			}
			
			if(i<b.length) {
				sum[i] += b[i];
			}
		}
		System.out.println("Sum of Given Two Array Is : "+Arrays.toString(sum));
	}
}
