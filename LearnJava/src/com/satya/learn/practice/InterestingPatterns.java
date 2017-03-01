package com.satya.learn.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3><a href=
 * 'http://www.practice.geeksforgeeks.org/problem-page.php?pid=1616'>Interesting
 * Patterns</a></h3> Given an integer N. Your task is to print the pattern.<br/>
 * <b>For example: <br/>
 * Input</b> N=4<br/>
 * <b>Output :</b><br/>
 * 4444444 <br/>
 * 4333334 <br/>
 * 4322234 <br/>
 * 4321234 <br/>
 * 4322234 <br/>
 * 4333334 <br/>
 * 4444444 <br/>
 * 
 * <b>Input:</b> First line consists of test cases.For each test case only one
 * line be the input containing an integer N.<br/>
 * 
 * <b>Output:</b> For each test case. Print the pattern in single line by giving
 * space instead of new line.<br/>
 * 
 * <b>Constraints:</b><br/>
 * 1<=T<=20<br/>
 * 1<=N<=20
 * 
 * @author Satyendra Sharma
 *
 */
public class InterestingPatterns {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<String> out = new LinkedList<>();
		for (int tc = 0; tc < t; tc++) {
			int n = in.nextInt();
			int r = (2 * n) - 1;
			int s = 0, e = r - 2;
			StringBuilder tOut = new StringBuilder();
			for (int mr = 0; mr < r; mr++) {
				int p = n;
				for (int mc = 0; mc < r; mc++) {
					tOut.append(p);
					if (mc < s || e < mc) {
						if (mc < n - 1) {
							p--;
						} else {
							p++;
						}
					}
				}
				if (mr < n - 1) {
					s++;
					e--;
				} else {
					s--;
					e++;
				}
				tOut.append(" ");
			}
			out.add(tOut.toString());
		}
		out.forEach(System.out::println);
		in.close();
	}

}
