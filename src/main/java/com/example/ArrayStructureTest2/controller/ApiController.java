package com.example.ArrayStructureTest2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ArrayStructureTest2.service.ApiService;

@RestController 
public class ApiController {
	
	@Autowired
	private ApiService service;
	
	@CrossOrigin
	@PostMapping("/test_cache_data")
	public Map<String, Object> getCacheData(@RequestBody Map<String, Object> request) {
		Map<String, Object> response = new HashMap<>();
		response=service.getServiceFunction();
		return response;
	}
}
