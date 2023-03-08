package com.example.ArrayStructureTest2.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	@Autowired
	private FileReaderUtility file_read;
	
	public Map<String, Object> getServiceFunction() {
		Map<String, Object> response = new HashMap<>();
		response=file_read.findRPLRecosCustandStory("customer_1@email.com", "UC001.Hybridizer.Reorder");
		return response ;
	}
}
