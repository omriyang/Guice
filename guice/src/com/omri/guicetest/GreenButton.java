package com.omri.guicetest;

public class GreenButton implements Button {

	@Override
	public void push(String letter) {
		System.out.println("I am green "+letter+" button!");
	}

}
