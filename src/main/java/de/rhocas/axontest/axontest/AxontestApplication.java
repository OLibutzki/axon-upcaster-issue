package de.rhocas.axontest.axontest;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.serialization.upcasting.event.EventUpcaster;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	void printEventUpcasters( final List<EventUpcaster> upcasters ) {
		System.out.println( "Event upcasters: " + upcasters
				.stream( )
				.map( Object::getClass )
				.map( Class::getSimpleName )
				.collect( Collectors.joining( ", " ) ) );
	}

}
