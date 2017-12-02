package com.app.opnshft.travelify.model;

import java.util.Iterator;
import java.util.List;


public class AutocompleteResult implements Iterable<Prediction> {
	
	private static final String OKAY_STATUS = "OK";

	private List<Prediction> predictions;
	
	private String status;
	
	public String getStatus( ) {
		return this.status;
	}
	
	public boolean isOkay( ) {
		return OKAY_STATUS.equals( this.getStatus( ) );
	}
	
	@Override
	public Iterator<Prediction> iterator( ) {
		return this.predictions.iterator( );
	}

	public int size( ) {
		return this.predictions.size( );
	}

}
