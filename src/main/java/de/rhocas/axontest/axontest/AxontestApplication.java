package de.rhocas.axontest.axontest;

import org.axonframework.eventhandling.gateway.EventGateway;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import de.rhocas.axontest.config1.Config1;
import de.rhocas.axontest.config2.Config2;

@SpringBootApplication
@Import( { Config2.class, Config1.class } )
public class AxontestApplication {

	public static void main( final String[] args ) throws InterruptedException {
		final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder( AxontestApplication.class )
				.logStartupInfo( false )
				.bannerMode( Mode.OFF )
				.run( args );

		final EventGateway eventGateway = applicationContext.getBean( EventGateway.class );
		eventGateway.publish( "Some event" );
	}

}
