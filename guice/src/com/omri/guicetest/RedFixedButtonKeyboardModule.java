package com.omri.guicetest;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class RedFixedButtonKeyboardModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Button.class).to(RedButton.class);
		bindConstant().annotatedWith(Names.named("letter")).to("X");
	}

}
