package com.Elastic.search.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.Elastic.search.dao.QueryDao;
import com.Elastic.search.entity.Document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@RestController
public class RestRequestController {

	//@Autowired
	private QueryDao document = new QueryDao();
	
	//@GetMapping(value = "/api/get")
	@RequestMapping(value = "/api/get" , method = RequestMethod.GET)
	public String create() {
		System.out.println("hgdhasvfhg");
		//return document.matchAllQuery();
		return "Hello";
	}
	
}
