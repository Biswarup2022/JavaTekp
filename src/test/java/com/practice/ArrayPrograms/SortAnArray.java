package com.practice.ArrayPrograms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortAnArray {

	public static void main(String[] args) {
		
		int[] arr = {2,1,6,5,3,10,9,7};
		
		for(int i=0; i<arr.length; i++) {
			
			for(int j=i+1; j<arr.length; j++) {
				
				if(arr[i] > arr[j]) {
					
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		int[] a = {1,2,3,4,5};
		int[] b = {6,7,4,3,2,1,8,9,10};
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(System.out::println);
	}
}
