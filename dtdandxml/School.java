package com.dtdandxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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

		Map<SchoolPojo,StudentPojo> map = new HashMap<SchoolPojo,StudentPojo>();

		File file = new File("/home/valuelabs/workspace/Threads/src/com/dtdandxml/school.xml");
		FileInputStream fis = new FileInputStream(file);
		Document document = builder.parse(fis);

		NodeList nodelist = document.getElementsByTagName("class");

		for ( int i = 0; i <  nodelist.getLength(); i++ ) {
			System.out.println("***************");
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

								if ( subnode.getNodeName().equalsIgnoreCase("firstname") ) {

									stdnt.setFirstname(subnode.getTextContent());
									System.out.println("first name :"+subnode.getTextContent());
								}
								if ( subnode.getNodeName().equalsIgnoreCase("lastname") ) {

									stdnt.setLastname(subnode.getTextContent());
									System.out.println("last name :"+subnode.getTextContent());
								}

							}
						}


						if ( childNode.getNodeName().equalsIgnoreCase("classteacher") ) {
							sp.setClassteacher(childNode.getTextContent());
							System.out.println("classtchr name :"+childNode.getTextContent());
						} 
						if ( childNode.getNodeName().equalsIgnoreCase("subjects") ) {

							sp.setSubs(Integer.parseInt(childNode.getTextContent()));
							System.out.println("subs :"+childNode.getTextContent());
						}

					}
				}
			}
			map.put(sp,stdnt);
			
			Iterator<Map.Entry<SchoolPojo,StudentPojo>> entries = map.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry<SchoolPojo,StudentPojo> entry = entries.next();
			    System.out.println("Key = " + entry.getKey().classnumber + ", value = " + entry.getValue().firstname);
			}
			
		}
	}
}
