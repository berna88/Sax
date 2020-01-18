package com.consistent.main;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.consistent.models.Rates;

public class RatesHandle extends DefaultHandler{
	
	private List<Rates> rateList = null;
	private Rates rate = null;
	private StringBuilder data = null;
	
	public List<Rates> getRates(){
		return rateList;
	}
	
	boolean bCode = false;
	boolean bName = false;
	boolean bKeyword = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		
		if(qName.equalsIgnoreCase("dynamic-element")){
			String name = attributes.getValue("name");
			rate = new Rates();
			if(name.equals("codeRate")){
				bCode = true;
			}else if(name.equals("nameRate")){
				bName = true;
			}else if(name.equals("keywordRate")){
				bKeyword = true;
			}
		}
	}

}
