package com.satya.learn.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given K sorted arrays arranged in a form of a matrix, your task is to merge
 * them. You need to complete mergeKArrays function which takes 2 arguments, an
 * arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the
 * no. of sorted arrays. The function should return a pointer to the merged
 * sorted arrays. There are multiple test cases. For each test case, this method
 * will be called individually.<br/>
 * 
 * <b>Input:</b> The first line of input will denote the no of Test cases then T
 * test cases will follow . Each test cases will contain an integer N denoting
 * the no of sorted arrays. Then in the next line contains all the elements of
 * the array separated by space.<br/>
 * 
 * <b>Output:</b> The output will be the sorted merged array.<br/>
 * 
 * <b>Constraints</b> 1<=T<=50 1<=N<=10
 * 
 * @author Satyendra Sharma
 *
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<ArrayList<Integer>> out = new ArrayList<>();
		for (int tc = 0; tc < t; tc++) {
			int k = in.nextInt();
			int[][] arr = new int[k][k];
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			out.add(mergeKArrays(arr, k));
		}
		in.close();
		out.stream().forEach(e -> {
			for (Integer i : e) {
				System.out.print(i + " ");
			}
			System.out.println();
		});
	}

	public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
		ArrayList<Integer> mrgArr = new ArrayList<>();
		int[] ptr = new int[k];
		Arrays.stream(ptr).forEach(p -> p = 0);
		for (int chk = 0; chk < (k * k); chk++) {
			int temp = 0, r = 0;
			boolean isAny = false;
			for (int i = 0; i < k; i++) {
				if (ptr[i] < k) {
					temp = arrays[i][ptr[i]];
					r = i;
					isAny = true;
					break;
				}
			}
			if (!isAny) {
				break;
			}
			for (int i = 0; i < k; i++) {
				if (ptr[i] < k && arrays[i][ptr[i]] < temp) {
					temp = arrays[i][ptr[i]];
					r = i;
				}
			}
			ptr[r]++;
			mrgArr.add(temp);
		}
		return mrgArr;
	}

}
