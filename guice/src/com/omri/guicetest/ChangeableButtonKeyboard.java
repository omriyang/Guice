package com.omri.guicetest;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class ChangeableButtonKeyboard implements Keyboard {
	final private String letter;
	final private Button button;
	
	@Inject
	public ChangeableButtonKeyboard(Button button, @Assisted String letter) {
		this.letter = letter;
		this.button = button;
	}
	
	public void pushButton() {
		System.out.println("Changeable Keyboard push");
		button.push(letter);
	}
}
