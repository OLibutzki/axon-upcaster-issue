package de.rhocas.axontest.axontest;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
class MyProjector {

	@EventHandler
	public void on( final String event ) {

	}

}