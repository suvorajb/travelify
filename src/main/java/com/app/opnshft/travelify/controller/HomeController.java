package com.app.opnshft.travelify.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.opnshft.travelify.cmn.TravelifyCmnUtil;
import com.app.opnshft.travelify.model.Place;
import com.app.opnshft.travelify.model.PlacesResult;

@Controller
public class HomeController {
	
	@Autowired
	private com.app.opnshft.travelify.svcs.TravelifyPlcsSvc placeSvc;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}

	
}
