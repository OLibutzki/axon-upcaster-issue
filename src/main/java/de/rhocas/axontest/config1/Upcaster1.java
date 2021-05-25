package de.rhocas.axontest.config1;

import org.axonframework.serialization.upcasting.event.IntermediateEventRepresentation;
import org.axonframework.serialization.upcasting.event.SingleEventUpcaster;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order( 1 )
public class Upcaster1 extends SingleEventUpcaster {

	@Override
	protected boolean canUpcast( final IntermediateEventRepresentation intermediateRepresentation ) {
		return true;
	}

	@Override
	protected IntermediateEventRepresentation doUpcast( final IntermediateEventRepresentation intermediateRepresentation ) {
		System.out.println( "Upcaster 1 executed" );
		return intermediateRepresentation;
	}

	@Override
	public String toString( ) {
		return "Upcaster 1";
	}

}
