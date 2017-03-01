package com.satya.learn.util;

import com.satya.learn.bean.Node;

public class MyHelper {

	private MyHelper() {
		// private constructor
	}
	
	public static void helpingYou(String msg, Node head, boolean doChange) {
		if(doChange) {
			msg = "We are trying to help you...";
			head.setData(123);
		}
	}
	
	

}
