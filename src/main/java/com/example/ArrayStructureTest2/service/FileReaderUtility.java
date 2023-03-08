package com.example.ArrayStructureTest2.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.example.ArrayStructureTest2.entity.Cust_Recos;

@Component
public class FileReaderUtility {
	public static List<Cust_Recos> custRecos = new ArrayList<Cust_Recos>();
	
	public void loadData(String filename) {
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
				String line_l;
			    while ((line_l = br.readLine()) != null) {
			    	String value_1=line_l.substring(0,StringUtils.ordinalIndexOf(line_l, "|", 1));
			    	String value_2=line_l.substring(StringUtils.ordinalIndexOf(line_l, "|", 1)+1,StringUtils.ordinalIndexOf(line_l, "|", 2));
			    	String value_3=line_l.substring(StringUtils.ordinalIndexOf(line_l, "|", 2)+1,line_l.length());
			    	custRecos.add(new Cust_Recos(value_1, value_2,value_3));
			        }
			}catch (IOException e) {
			      e.printStackTrace();
		    }
			
		}catch(Exception e) {
			System.out.println(e);
			System.out.println(Instant.now() + " | ERROR | " + e);
			System.exit(0);
		}
	}
	
	public Map<String, Object> findRPLRecosCustandStory(String cust_id,String story_id){
		Map<String, Object> response = new HashMap<>();
		List<Cust_Recos> reco_list = new ArrayList<Cust_Recos>();
		try {
			reco_list=custRecos.stream().filter(p -> p.getCustId().equals(cust_id) && p.getStoryId().equals(story_id)).collect(Collectors.toList());
			response.put("Response", reco_list.get(0).getRecos());
			}catch(Exception e) {
				Map<String, Object> err_response = new HashMap<>();
				err_response.put("Error", "Recos Not found for this Customer and Use Case Pair");
				System.out.println(Instant.now() + " | ERROR | " + e);
				return err_response;
			}
		return response;
	}
}
