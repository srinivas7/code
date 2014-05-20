package com.dtdandxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class School {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		SchoolPojo sp = null;
		StudentPojo stdnt = null ;

		Map<SchoolPojo,List> map = new HashMap<SchoolPojo,List>();
		List<StudentPojo> list = null;
		

		File file = new File("/home/valuelabs/workspace/Threads/src/com/dtdandxml/school.xml");
		FileInputStream fis = new FileInputStream(file);
		Document document = builder.parse(fis);

		NodeList nodelist = document.getElementsByTagName("class");

		for ( int i = 0; i <  nodelist.getLength(); i++ ) {
			System.out.println("*************************");
			Node currentNode = nodelist.item(i);



			if(currentNode instanceof Element){
				
				sp = new SchoolPojo();

				sp.setClassnumber(Integer.parseInt(((Element) currentNode).getAttribute("number")));
				System.out.println("class number : "+Integer.parseInt(((Element) currentNode).getAttribute("number")));
				NodeList childNodes = currentNode.getChildNodes();

				for ( int j = 0; j < childNodes.getLength(); j++ ) {
					Node childNode = childNodes.item(j);

					if ( childNode instanceof Element ) {

						if(childNode.hasChildNodes()){

							NodeList subnodelist = childNode.getChildNodes();

							for(int k=0;k<subnodelist.getLength();k++){

								Node subnode = subnodelist.item(k);
								stdnt = new StudentPojo();

								list = new ArrayList<StudentPojo>();
								
								if ( subnode.getNodeName().equalsIgnoreCase("firstname") ) {

									stdnt.setFirstname(subnode.getTextContent());
									System.out.println("first name :"+subnode.getTextContent());
								}
								if ( subnode.getNodeName().equalsIgnoreCase("lastname") ) {

									stdnt.setLastname(subnode.getTextContent());
									System.out.println("last name :"+subnode.getTextContent());
								}
								if ( subnode.getNodeName().equalsIgnoreCase("DOB") ) {
									
									SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
									
								 
									Date date = null;
									try {
								 
										 date = (Date) formatter.parse(subnode.getTextContent());
										
									} catch (ParseException e) {
										e.printStackTrace();
									}

									stdnt.setDob(date);
									System.out.println("DOB :"+subnode.getTextContent());
								}
								if ( subnode.getNodeName().equalsIgnoreCase("address") ) {

									stdnt.setAddress(subnode.getTextContent());
									System.out.println("Address :"+subnode.getTextContent());
								}

								list.add(stdnt);
							}
						}


						if ( childNode.getNodeName().equalsIgnoreCase("classteacher") ) {
							sp.setClassteacher(childNode.getTextContent());
							System.out.println("classtchr name :"+childNode.getTextContent());
						} 
						if ( childNode.getNodeName().equalsIgnoreCase("subjects") ) {

							sp.setSubs(Integer.parseInt(childNode.getTextContent()));
							System.out.println("NO.Of subs :"+childNode.getTextContent());
						}

					}
				}
			}
			map.put(sp,list);
			
			Iterator<Map.Entry<SchoolPojo,List>> entries = map.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry<SchoolPojo,List> entry = entries.next();
			    System.out.println("Key = " + entry.getKey().classnumber);
			    List<StudentPojo> ll = entry.getValue();
			    System.out.println(ll.size());
			    Iterator<StudentPojo> listiterator = ll.iterator();
			    while(listiterator.hasNext()){
			    	StudentPojo ssp = listiterator.next();
			    	if(ssp.getFirstname() != null)
			    	System.out.print("first name :"+ssp.getFirstname());
			    	if(ssp.getLastname() != null)
			    		System.out.println(", last name : "+ssp.getLastname());
			    }
			}
			System.out.println("list size : "+list.size());
			
			
		}
	}
}
