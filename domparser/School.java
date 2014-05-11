package com.domparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

		Map<String,SchoolPojo> map = new HashMap<String,SchoolPojo>();
		List<StudentPojo> list = new ArrayList<StudentPojo>();


		File file = new File("/home/valuelabs/workspace/Threads/src/com/domparser/school.xml");
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

								//list = new ArrayList<StudentPojo>();

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
								sp.setList(list);

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
			map.put(sp.getClassteacher(),sp);
			
			Iterator<Map.Entry<String,SchoolPojo>> entries = map.entrySet().iterator();
			
			while(entries.hasNext()){
				Entry<String,SchoolPojo> en = entries.next();
				System.out.println("Key value is "+en.getKey());
				System.out.println("Values are :");
				SchoolPojo spp =en.getValue();
				List<StudentPojo> student = spp.getList();
				Iterator student_iterator = student.iterator();
				while(student_iterator.hasNext()){
					StudentPojo s = (StudentPojo) student_iterator.next();
					if(s.firstname != null)
					System.out.print(" ,first name "+s.firstname);
					if(s.lastname != null)
						System.out.print("last name"+s.lastname);
						if(s.address != null)
							System.out.print("address"+s.address);
					if(s.dob != null)
						System.out.println(", dob"+s.dob);
				}
			}
			

		}
	}
}
