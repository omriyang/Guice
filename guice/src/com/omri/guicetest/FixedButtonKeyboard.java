package com.omri.guicetest;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class FixedButtonKeyboard implements Keyboard {
	private Button button;
	private String letter;
	
	@Inject
	public FixedButtonKeyboard(Button button, @Named("letter") String letter) {
		this.button = button;
		this.letter = letter;
	}
	
	public void pushButton() {
		System.out.println("Fixed Keyboard push");
		button.push(letter);
	}
}
