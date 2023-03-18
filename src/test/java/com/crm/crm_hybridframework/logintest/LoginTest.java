package com.crm.crm_hybridframework.logintest;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.crm.crm_hybridframework.base.ExcelReader;
import com.crm.crm_hybridframework.base.Keywords;
import com.crm.crm_hybridframework.base.KeywordsImpl;

public class LoginTest {
	
	Keywords keyword = new KeywordsImpl();

	@Test
	public void test() {
		
		ArrayList testData = ExcelReader.getTestData(
				"C:\\Users\\user\\Desktop\\Pankaj_Java_Testing\\Manual_Testing\\templates\\LoginTestCase.xlsx");
		
		for(int i=0; i < testData.size(); i++) {
			
			if(testData.get(i).equals("open")) 
				keyword.open(); 
			
			if(testData.get(i).equals("url")) 
				keyword.url(testData.get(i + 1).toString()); 
			
			if(testData.get(i).equals("input")) {
				
				String inputData = testData.get(i + 1).toString();
				
				String objectName = testData.get(i + 2).toString();
				
				keyword.input(inputData, objectName);
			}
			
			if(testData.get(i).equals("click")) {
				
				String objectName = testData.get(i + 2).toString();
				
				keyword.click(objectName);
			}	
			
			if(testData.get(i).equals("quit")) {
				
				keyword.quit();
			}	
						
		}
		
	}
}
