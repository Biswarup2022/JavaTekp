package com.practice.ArrayPrograms;

import java.util.Arrays;

public class MergeAndSortArrays {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6};
		int[] b = {7,8,9,12,45,7};
		int[] res = new int[a.length+b.length];
		int count = 0;
		
		for(int i = 0; i<res.length; i++) {
			
			if(i < a.length) {
				res[i] = a[i];
			}
			else {
				res[i] = b[count];
				count++;
			}
		}
		for(int i = 0; i<res.length; i++) {
			for(int j = i+1; j<res.length; j++) {
				
				if(res[i] > res[j]) {
					int temp = res[i];
					res[i] = res[j];
					res[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(res));
	}
}
