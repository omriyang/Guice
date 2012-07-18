package com.omri.guicetest;

public class RedButton implements Button {

	@Override
	public void push(String letter) {
		System.out.println("I am red "+letter+" button!");
	}

}
