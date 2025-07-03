package com.practice.ArrayPrograms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FindDuplicatePosition {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the LENGTH of Your Array : ");
		int x = sc.nextInt();
		int[] a = new int[x];
		
		for(int j=0; j<a.length; j++) {
			
			System.out.println("Enter Your Array Value with DUPLICATES : ");
			a[j] = sc.nextInt();
		}
//		int[] a = {1,2,3,1,2,3,3,4};
		LinkedHashMap<Integer, ArrayList> hash = new LinkedHashMap();
		for(int i=0; i<a.length; i++) {
			if(hash.containsKey(a[i])) {
				hash.get(a[i]).add(i);
			}
			else {
				hash.put(a[i], new ArrayList());
			}
		}
		
		for(Entry<Integer, ArrayList> map : hash.entrySet()) {
			if(map.getValue().size()>0) {
				System.out.println(map.getKey()+" ==> "+map.getValue());
			}
		}
	}
}
