package com.consistent.main;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.consistent.models.Employee;

public class MyHandler extends DefaultHandler{
	
	private List<Employee> empList = null;
	private Employee emp = null;
	private StringBuilder data = null;
	
	public List<Employee> getEmpList(){
		return empList;
	}
	
	boolean bAge = false;
	boolean bName = false;
	boolean bGender = false;
	boolean bRole = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if(qName.equalsIgnoreCase("Employee")){
			String id = attributes.getValue("id");
			emp = new Employee();
			emp.setId(Integer.parseInt(id));
			
			if(empList == null)
					empList = new ArrayList<>();
		}else if(qName.equalsIgnoreCase("name")){
			bName = true;
		}else if(qName.equalsIgnoreCase("age")){
			bAge = true;
		}else if(qName.equalsIgnoreCase("gender")){
			bGender = true;
		}else if(qName.equalsIgnoreCase("role")){
			bRole = true;
		}
		data = new StringBuilder();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		
		if(bAge){
			emp.setAge(Integer.parseInt(data.toString()));
			bAge = false;
		}else if(bName){
			emp.setName(data.toString());
			bName = false;
		}else if(bRole){
			emp.setRole(data.toString());
			bRole = false;
		}else if(bGender){
			emp.setGender(data.toString());
			bGender = false;
		}
		
		if(qName.equalsIgnoreCase("Employee")){
			empList.add(emp);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		data.append(new String(ch,start, length));
	}
}
