package com.omri.guicetest;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class GreenChangeableButtonKeyboardModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Button.class).to(GreenButton.class);
		install(new FactoryModuleBuilder().implement(Keyboard.class, ChangeableButtonKeyboard.class).build(KeyboardFactory.class));
	}

}
