package com.practice.ArrayPrograms;

import java.util.LinkedHashSet;

public class TargetSum {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,5,6,7,8,1};
		int targetSum = 9;
		
		LinkedHashSet set = new LinkedHashSet();
		
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				
				if(a[i] + a[j] == targetSum) {
					
					String sum = a[i] > a[j]?"("+a[j]+" , "+a[i]+")":"("+a[i]+" , "+a[j]+")";
					set.add(sum);
				}
			}
		}
		System.out.println(set);
	}
}
