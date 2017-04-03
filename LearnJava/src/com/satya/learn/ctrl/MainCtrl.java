package com.satya.learn.ctrl;

class MainCtrl {

	private static int ctr = 0;

	private MainCtrl() {
		System.out.println("private constructor of MainCtrl");
	}

	public static void main(String[] args) {
		System.out.println("MainCtrl");
		MainCtrl mc = new MainCtrl();
		mc.printer();
		mc.printer();
	}

	private void printer() {
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Counter :: " + ctr++);
	}
}

class Satya {

	public static void main(String[] args) {
		System.out.println("Satya....");
	}
}
