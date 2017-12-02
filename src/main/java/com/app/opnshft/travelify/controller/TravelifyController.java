package com.app.opnshft.travelify.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.opnshft.travelify.cmn.TravelifyCmnUtil;
import com.app.opnshft.travelify.form.CitySearchForm;
import com.app.opnshft.travelify.model.Place;
import com.app.opnshft.travelify.model.PlaceDetailResult;
import com.app.opnshft.travelify.model.PlacesResult;
import com.app.opnshft.travelify.model.PlacesSuggestResult;
import com.google.gson.Gson;

@Controller
public class TravelifyController {

	@Autowired
	private com.app.opnshft.travelify.svcs.TravelifyPlcsSvc placeSvc;

	@RequestMapping(value = "/travelicity", method = RequestMethod.GET)
	public ModelAndView travelicity(HttpServletRequest req, Model uiModel) {
		CitySearchForm citysearchform = new CitySearchForm();
		uiModel.addAttribute("citysearchform", citysearchform);
		return new ModelAndView(TravelifyCmnUtil._VIEW_CITY_GRID);
	}

	
	@RequestMapping(value = "/travelicity/guide/{citynm}", method = RequestMethod.GET)
	public String redirCitySrch(@PathVariable("citynm") final String citynm, Model uiModel,
			HttpServletRequest req) {

		return  "redirect:/travelicity/guide/eating/"+citynm;

	}
	
	
	@RequestMapping(value = "/travelicity/guide/eating/{citynm}", method = RequestMethod.GET)
	public ModelAndView eatingGuideList(@PathVariable("citynm") final String citynm, Model uiModel,
			HttpServletRequest req) {
		PlacesResult result = null;

		String types = req.getParameter("types");
		String query = req.getParameter("query");
		String cat = req.getParameter("cat");
		
		if (StringUtils.isBlank(query)) {
			query = "top+rated+restaurants+in+" + citynm;
		}
		
		if (types != null && types != "") {
			result = placeSvc.search(query, 10000, types, false);
		} else if (query != null && query != "") {
			result = placeSvc.search(query, 10000, false);
		} else {
			result = placeSvc.search(query, 20000, false);
		}

		if (result.isOkay()) {
			List<Place> places = result.asList();
			System.out.println("plces-" + places);

			uiModel.addAttribute("places", places);
		} else {
			uiModel.addAttribute("message", "no result");
		}


		uiModel.addAttribute("hdng", StringUtils.capitalize(StringUtils.replace(query, "+", " ")));

		uiModel.addAttribute("citynm", citynm);

		if (cat != null && cat != "") {
			uiModel.addAttribute("cat", cat);
		} else {
			uiModel.addAttribute("cat", "restaurants");
		}

		return new ModelAndView(TravelifyCmnUtil._VIEW_EATING_GUIDE);

	}

	
	@RequestMapping(value = "/travelicity/guide/travel/{citynm}", method = RequestMethod.GET)
	public ModelAndView travelGuideList(@PathVariable("citynm") final String citynm, Model uiModel,
			HttpServletRequest req) {
		PlacesResult result = null;

		String types = req.getParameter("types");
		String query = req.getParameter("query");
		String cat = req.getParameter("cat");
		
		if (StringUtils.isBlank(query)) {
			query = "top+rated+hotels+and+lodge+in+" + citynm;
		}
		
		if (types != null && types != "") {
			result = placeSvc.search(query, 10000, types, false);
		} else if (query != null && query != "") {
			result = placeSvc.search(query, 10000, false);
		} else {
			result = placeSvc.search(query, 20000, false);
		}

		if (result.isOkay()) {
			List<Place> places = result.asList();
			System.out.println("plces-" + places);

			uiModel.addAttribute("places", places);
		} else {
			uiModel.addAttribute("message", "no result");
		}


		uiModel.addAttribute("hdng", StringUtils.capitalize(StringUtils.replace(query, "+", " ")));

		uiModel.addAttribute("citynm", citynm);

		if (cat != null && cat != "") {
			uiModel.addAttribute("cat", cat);
		} else {
			uiModel.addAttribute("cat", "restaurants");
		}

		return new ModelAndView(TravelifyCmnUtil._VIEW_TRVL_GUIDE);

	}

	
	
	@RequestMapping(value = "/travelicity/guide/attractions/{citynm}", method = RequestMethod.GET)
	public ModelAndView attrctnsGuideList(@PathVariable("citynm") final String citynm, Model uiModel,
			HttpServletRequest req) {
		PlacesResult result = null;

		String types = req.getParameter("types");
		String query = req.getParameter("query");
		String cat = req.getParameter("cat");
		
		if (StringUtils.isBlank(query)) {
			query = "popular+amusement+park+in+" + citynm;
		}
		
		if (types != null && types != "") {
			result = placeSvc.search(query, 10000, types, false);
		} else if (query != null && query != "") {
			result = placeSvc.search(query, 10000, false);
		} else {
			result = placeSvc.search(query, 20000, false);
		}

		if (result.isOkay()) {
			List<Place> places = result.asList();
			System.out.println("plces-" + places);

			uiModel.addAttribute("places", places);
		} else {
			uiModel.addAttribute("message", "no result");
		}


		uiModel.addAttribute("hdng", StringUtils.capitalize(StringUtils.replace(query, "+", " ")));

		uiModel.addAttribute("citynm", citynm);

		if (cat != null && cat != "") {
			uiModel.addAttribute("cat", cat);
		} else {
			uiModel.addAttribute("cat", "restaurants");
		}

		return new ModelAndView(TravelifyCmnUtil._VIEW_ATTRCTNS_GUIDE);

	}
	
	
	@RequestMapping(value = "/travelicity/guide/", method = RequestMethod.POST)
	public ModelAndView searchcityguidelist(@ModelAttribute CitySearchForm citysearchform, BindingResult rslt,
			Model uiModel, HttpServletRequest req) {
		PlacesResult result = null;

		String citynm = citysearchform.getCitynm();

		result = placeSvc.search("top+rated+restaurants+in+" + citynm, 20000, false);

		if (result.isOkay()) {
			List<Place> places = result.asList();

			uiModel.addAttribute("places", places);
		} else {
			uiModel.addAttribute("message", "no result");
		}

		uiModel.addAttribute("citysearchform", citysearchform);
		uiModel.addAttribute("citynm", citynm);

		return new ModelAndView(TravelifyCmnUtil._VIEW_EATING_GUIDE);
	}

	@RequestMapping(value = "/travelicity/showdtls", method = RequestMethod.GET)
	public ModelAndView showCityDtls(@RequestParam("ref") final String reference,
			@RequestParam("citynm") final String citynm, Model uiModel, HttpServletRequest req) {

		uiModel.addAttribute("citynm", citynm);

		PlaceDetailResult result = placeSvc.detail(reference, false);

		if (result.isOkay()) {
			uiModel.addAttribute("placedls", result.getResult());
		} else {
			uiModel.addAttribute("message", "no result");
		}

		return new ModelAndView(TravelifyCmnUtil._VIEW_CITY_DTLS);
	}
	@RequestMapping(value = "/placequery", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String placeQuery(@RequestParam("query") final String query,
			@RequestParam("type") final String type, @RequestParam("resultcnt") final int resultcnt) {

		String jsonstr = "";

		Gson gson = new Gson();

		// System.out.println("query-"+query);

		PlacesSuggestResult rslt = placeSvc.suggest(query, 20000, type, resultcnt, false);

		jsonstr = gson.toJson(rslt);

		// System.out.println("jsonstr-" + jsonstr);

		return jsonstr;
	}

	@RequestMapping(value = "/searchquery", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String searchQuery(@RequestParam("query") final String query,
			@RequestParam("resultcnt") final int resultcnt) {

		String jsonstr = "";

		Gson gson = new Gson();

		// System.out.println("query-" + query);

		PlacesResult rslt = placeSvc.search(query, 20000, false);

		jsonstr = gson.toJson(rslt);

		// System.out.println("jsonstr-" + jsonstr);

		return jsonstr;
	}

}
