package com.satya.learn.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainCtrl {

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
