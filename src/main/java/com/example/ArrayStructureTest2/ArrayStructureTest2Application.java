package com.example.ArrayStructureTest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.example.ArrayStructureTest2.service.FileReaderUtility;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ArrayStructureTest2Application {

	public static void main(String[] args) {
		String rpl_filename="";
		rpl_filename=args[0];
		try  {	           
			FileReaderUtility file_1 = new FileReaderUtility();
	        file_1.loadData(rpl_filename);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		SpringApplication.run(ArrayStructureTest2Application.class, args);
	}

}
