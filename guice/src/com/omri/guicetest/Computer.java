package com.omri.guicetest;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class Computer {
	@Inject
	KeyboardFactory keyboardFactory;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new RedFixedButtonKeyboardModule());
		Keyboard keyboard = injector.getInstance(FixedButtonKeyboard.class);
		keyboard.pushButton();
		
		injector = Guice.createInjector(new RedFixedButtonKeyboardModule() {
			@Override
			protected void configure() {
				bind(Button.class).to(GreenButton.class);
				bindConstant().annotatedWith(Names.named("letter")).to("Y");
			}
		});
		keyboard = injector.getInstance(FixedButtonKeyboard.class);
		keyboard.pushButton();
		
		final String specialLetter = new String("Z");
		injector = Guice.createInjector(new RedFixedButtonKeyboardModule() {
			@Override
			protected void configure() {
				bind(Button.class).to(RedButton.class);
				bind(String.class).annotatedWith(Names.named("letter")).toInstance(specialLetter);
			}
		});
		keyboard = injector.getInstance(FixedButtonKeyboard.class);
		keyboard.pushButton();
		
		
		injector = Guice.createInjector(new GreenChangeableButtonKeyboardModule());
		keyboard = injector.getInstance(KeyboardFactory.class).create("A");
		keyboard.pushButton();
		
	}

}
