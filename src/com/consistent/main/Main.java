package com.consistent.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.consistent.models.Employee;

public class Main extends DefaultHandler{
	
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(new File("/Users/bernardohernandez/Downloads/employees.xml"), handler);
			
			List<Employee> empList = handler.getEmpList();
			
			for(Employee emp : empList){
				System.out.println(emp);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
