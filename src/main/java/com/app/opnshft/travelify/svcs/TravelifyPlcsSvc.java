package com.app.opnshft.travelify.svcs;

import java.net.URL;
import java.util.List;
import java.util.Map;

import com.app.opnshft.travelify.model.AutocompleteQueryOptions;
import com.app.opnshft.travelify.model.AutocompleteResult;
import com.app.opnshft.travelify.model.Place;
import com.app.opnshft.travelify.model.PlaceDetailResult;
import com.app.opnshft.travelify.model.PlacesQueryOptions;
import com.app.opnshft.travelify.model.PlacesResult;
import com.app.opnshft.travelify.model.PlacesSuggestResult;
import com.claygregory.common.data.geo.GeoLocation;

public interface TravelifyPlcsSvc {
	
	public final int DEFAULT_RADIUS = 500;

	public final String AUTOCOMPLETE_URL = "https://maps.googleapis.com/maps/api/place/autocomplete/json";

	public final String DETAIL_URL = "https://maps.googleapis.com/maps/api/place/details/json";

	public final String PHOTO_URL = "https://maps.googleapis.com/maps/api/place/photo";

	public final String SEARCH_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
	
	public final String TXT_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json";
	
	//public final String apikey = "AIzaSyCXasoa_-_S00WnsdIDBfV4eX9G7Rhnz0U";
	public final String apikey = "AIzaSyCmUrF7Fhn6l7oEuRI0U9FPOO3rNUsW29M";
	
	public AutocompleteResult autocomplete(String input, boolean sensor);
	public AutocompleteResult autocomplete(String input, AutocompleteQueryOptions options, boolean sensor);
	
	
	
	public PlaceDetailResult detail(String reference, boolean sensor);
	
	public URL photoUrl(String photoReference, String maxHeight, String maxWidth, boolean sensor);

	
	public PlacesResult search(String pageToken, boolean sensor);
	public PlacesResult search(GeoLocation location, boolean sensor);
	//public PlacesResult search(float lat, float lon, int radius, boolean sensor);	
	public PlacesResult search(float lat, float lon, int radius, String keyword, boolean sensor);
	public PlacesResult search(GeoLocation location, PlacesQueryOptions options, boolean sensor);
	public PlacesResult search(float lat, float lon, int radius, PlacesQueryOptions options, boolean sensor);
	public PlacesResult search(float lat, float lon, PlacesQueryOptions options, boolean sensor);
	public PlacesResult search(String query, int radius, String type, boolean sensor);
	public PlacesResult search(String query, int radius, boolean sensor);
	
	public Map<String, List<Place>> recommend(float lat, float lon, int radius, String type, int count, boolean sensor);
	
	public Map<String, List<Place>> getTripPlanPlaces(String citynm, String[] plctypes);
	
	public PlacesSuggestResult suggest(float lat, float lon, int radius, String type, int count, boolean sensor);
	public PlacesSuggestResult suggest(String query, int radius, String type, int count, boolean sensor);
	public PlacesSuggestResult suggest(String query, int radius, int count, boolean sensor);

}
