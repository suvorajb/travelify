package com.app.opnshft.travelify.cmn;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Years;

import com.app.opnshft.travelify.model.AutocompleteResult;
import com.app.opnshft.travelify.model.PlaceDetailResult;
import com.app.opnshft.travelify.model.PlacesResult;
import com.claygregory.common.net.URLBuilder;
import com.google.gson.Gson;

public class TravelifyCmnUtil {

	public final static String _VIEW_CITY_GRID 		= "citygrid";
	public final static String _VIEW_EATING_GUIDE 	= "eating";
	public final static String _VIEW_CITY_DTLS 		= "eating_dtls";
	
	public final static String _VIEW_TRVL_GUIDE 	= "travel";
	public final static String _VIEW_ATTRCTNS_GUIDE 	= "attractions";

	public final static String mapsapikey = "AIzaSyCXasoa_-_S00WnsdIDBfV4eX9G7Rhnz0U";


	public static HttpResponse invokeUrl(URLBuilder builder) throws IOException, MalformedURLException, Exception {
		String url_to_invk = builder.buildURL().toString();

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url_to_invk);
		getRequest.addHeader("accept", "application/json");
		HttpResponse httpRspnse = httpClient.execute(getRequest);

		return httpRspnse;
	}

	public static HttpResponse invokeUrl(URL url) throws IOException, MalformedURLException, Exception {
		String url_to_invk = url.toString();
		// System.out.println("URL invoked - " + url_to_invk);
		/*
		 * UrlFetchTransport urlTrnsprt = new UrlFetchTransport();
		 * HttpRequestFactory httpRqstFctry = urlTrnsprt.createRequestFactory();
		 * HttpRequest httpRqst = httpRqstFctry.buildGetRequest(new GenericUrl(
		 * url_to_invk)); HttpResponse httpRspnse = httpRqst.execute(); return
		 * httpRspnse;
		 */
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url_to_invk);
		getRequest.addHeader("accept", "application/json");
		HttpResponse httpRspnse = httpClient.execute(getRequest);

		return httpRspnse;
	}

	public static HttpResponse invokeUrl(String url_to_invk) throws IOException, MalformedURLException, Exception {
		// System.out.println("URL invoked - " + url_to_invk);
		/*
		 * UrlFetchTransport urlTrnsprt = new UrlFetchTransport();
		 * HttpRequestFactory httpRqstFctry = urlTrnsprt.createRequestFactory();
		 * HttpRequest httpRqst = httpRqstFctry.buildGetRequest(new GenericUrl(
		 * url_to_invk)); HttpResponse httpRspnse = httpRqst.execute(); return
		 * httpRspnse;
		 */

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url_to_invk);
		getRequest.addHeader("accept", "application/json");
		HttpResponse httpRspnse = httpClient.execute(getRequest);

		return httpRspnse;
	}

	public static AutocompleteResult parseAutocompleteResponse(HttpResponse response, Gson gson) throws IOException {

		return gson.fromJson(new InputStreamReader(response.getEntity().getContent()), AutocompleteResult.class);
	}

	public static PlaceDetailResult parseDetailResponse(HttpResponse response, Gson gson) throws IOException {
		return gson.fromJson(new InputStreamReader(response.getEntity().getContent()), PlaceDetailResult.class);
	}

	public static PlacesResult parseSearchResponse(HttpResponse response, Gson gson) throws IOException {
		return gson.fromJson(new InputStreamReader(response.getEntity().getContent()), PlacesResult.class);
	}

	public static String printDtttmStr(String nxtDateStr) {
		StringBuilder dtdiffStr = new StringBuilder("Published ");
		boolean flagDtFormatted = false;
		int daysDiff = 0;
		int monthDiff = 0;
		int yearDiff = 0;
		Date nxtDate = new Date();

		try {
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
			nxtDate = format.parse(nxtDateStr);

			DateTime todayDttm = new DateTime();// current date
			DateTime nextDttm = new DateTime(nxtDate); // next date to find the
														// difference

			daysDiff = Days.daysBetween(nextDttm, todayDttm).getDays();
			monthDiff = Months.monthsBetween(nextDttm, todayDttm).getMonths();
			yearDiff = Years.yearsBetween(nextDttm, todayDttm).getYears();

			if (yearDiff > 0) {
				dtdiffStr.append(yearDiff).append(yearDiff == 1 ? " Year " : " Years ");
				flagDtFormatted = true;
			}

			if (!flagDtFormatted) {
				if (monthDiff > 0) {
					dtdiffStr.append(monthDiff).append(monthDiff == 1 ? " Month " : " Months ");
					flagDtFormatted = true;
				}
			}

			if (!flagDtFormatted) {
				if (daysDiff > 0) {
					dtdiffStr.append(daysDiff).append(daysDiff == 1 ? " Day " : " Days ");
					flagDtFormatted = true;
				}
			}

			if (!flagDtFormatted && daysDiff == 0) {
				dtdiffStr.append("Today ");
			} else {
				dtdiffStr.append("Ago ");
			}
		} catch (ParseException pe) {
			dtdiffStr.append(nxtDateStr);
		}

		return dtdiffStr.toString();
	}

	public static String getProfilePicLnk(String gplusLnk, String uid) {
		StringBuilder picLnkStr = new StringBuilder("https://plus.google.com/s2/photos/profile/");
		// https://plus.google.com/103291556674373289857
		if (StringUtils.isNotBlank(gplusLnk)) {
			uid = StringUtils.substring(gplusLnk, StringUtils.indexOf(gplusLnk, "https://plus.google.com/"));
		}
		picLnkStr.append(uid);

		return picLnkStr.toString();
	}
}
