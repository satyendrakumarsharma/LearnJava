package com.satya.learn.practice;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * <h3><a href='http://www.practice.geeksforgeeks.org/problem-page.php?pid=493'>
 * Sorting Elements of an Array by Frequency</a></h3>
 * 
 * Given an array of integers, sort the array according to frequency of
 * elements. For example, if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3,
 * 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}. <i>If
 * frequencies of two elements are same, print them in increasing order.</i>
 * <br/>
 * 
 * <b>Input:</b><br/>
 * The first line of input contains an integer T denoting the number of test
 * cases. The description of T test cases follows. The first line of each test
 * case contains a single integer N denoting the size of array. The second line
 * contains N space-separated integers A1, A2, ..., AN denoting the elements of
 * the array.<br/>
 * 
 * <b>Output:</b><br/>
 * Print each sorted array in a seperate line. For each array its numbers should
 * be seperated by space.<br/>
 * 
 * <b>Constraints:</b><br/>
 * 1 <= T <= 70<br/>
 * 30 <= N <= 130<br/>
 * 1 <= A [ i ] <= 60
 * 
 * @author Satyendra Sharma
 */
public class SortArrayByFrequency {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<List<Integer>> out = new LinkedList<>();

		int tc = in.nextInt();
		for (int ti = 0; ti < tc; ti++) {
			int n = in.nextInt();
			Map<Integer, Integer> eF = new LinkedHashMap<>();
			for (int i = 0; i < n; i++) {
				int e = in.nextInt();
				if (eF.containsKey(e)) {
					eF.put(e, eF.get(e) + 1);
				} else {
					eF.put(e, 1);
				}
			}
			List<Entry<Integer, Integer>> li = new LinkedList<>(eF.entrySet());
			Collections.sort(li, (o1, o2) -> {
				// decreasing order of frequency.
				if (o1.getValue() > o2.getValue()) {
					return -1;
				} else if (o1.getValue() < o2.getValue()) {
					return 1;
				} else {
					// in case of equal frequency, increasing order of elements.
					if (o1.getKey() < o2.getKey()) {
						return -1;
					} else if (o1.getKey() > o2.getKey()) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			List<Integer> sList = new LinkedList<>();
			for (Map.Entry<Integer, Integer> es : li) {
				for (int i = 0; i < es.getValue(); i++) {
					sList.add(es.getKey());
				}
			}
			out.add(sList);
		}

		out.forEach(ol -> {
			ol.forEach(e -> {
				System.out.print(e + " ");
			});
			System.out.println();
		});
		in.close();
	}

}
