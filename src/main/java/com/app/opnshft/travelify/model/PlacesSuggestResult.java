package com.app.opnshft.travelify.model;

import java.util.List;

public class PlacesSuggestResult {
	List<Place> places;
	String mssg;

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public String getMssg() {
		return mssg;
	}

	public void setMssg(String mssg) {
		this.mssg = mssg;
	}
	
	
}
