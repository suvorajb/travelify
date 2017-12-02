package com.app.opnshft.travelify.model;

import java.util.Collections;
import java.util.List;

public class OpeningHours {

	private boolean openNow;
	
	private List<OpenPeriod> periods = Collections.emptyList( );

	public List<OpenPeriod> getPeriods( ) {
		return this.periods;
	}

	public boolean getOpenNow( ) {
		return this.openNow;
	}
	
}
