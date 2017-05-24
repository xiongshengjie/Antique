package com.antique.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.antique.domain.Antique;

public class AntiqueDao {

	public List<Antique> listAll() throws DocumentException {
		SAXReader reader = new SAXReader();
		
		List<Antique> list = new ArrayList<Antique>();
		Antique antique;
		Document document = reader.read(new File(getClass().getClassLoader().getResource("antique.xml").getPath()));
		
		Element root = document.getRootElement();
		List<Element> antiqueList = root.elements("antique");
		
		for(Element element : antiqueList){
			Attribute id = element.attribute("id");
			Attribute name = element.attribute("name");
			Attribute category = element.attribute("category");
			
			Element size = element.element("size");
			Element createtime = element.element("createtime");
			Element findtime = element.element("findtime");
			Element findplace = element.element("findplace");
			Element description = element.element("description");
			Element imgurl = element.element("imgurl");
			
			antique = new Antique(id.getStringValue(),name.getStringValue(),category.getStringValue(),
											size.getStringValue(),createtime.getStringValue(),findtime.getStringValue(),
											findplace.getStringValue(),description.getStringValue(),imgurl.getStringValue());
			list.add(antique);
		}
		
		return list;
	}
	
	public void add(Antique antique) throws IOException, DocumentException {
		SAXReader reader = new SAXReader();

		Document document;
		document = reader.read(new File(getClass().getClassLoader().getResource("antique.xml").getPath()));

		Element root = document.getRootElement();

		Element xmlantique = root.addElement("antique");
		xmlantique.addAttribute("id", antique.getId());
		xmlantique.addAttribute("name", antique.getName());
		xmlantique.addAttribute("category", antique.getCategory());

		Element size = xmlantique.addElement("size");
		size.setText(antique.getSize());
		Element createtime = xmlantique.addElement("createtime");
		createtime.setText(antique.getCreatetime());
		Element findtime = xmlantique.addElement("findtime");
		findtime.setText(antique.getFindtime());
		Element findplace = xmlantique.addElement("findplace");
		findplace.setText(antique.getFindplace());
		Element description = xmlantique.addElement("description");
		description.setText(antique.getDescription());
		Element imgurl = xmlantique.addElement("imgurl");
		imgurl.setText(antique.getImgurl());

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File(getClass().getClassLoader().getResource("antique.xml").getPath())), format);
		xmlWriter.write(document);
	}
	
	public void del(String id) throws DocumentException, IOException {
		SAXReader reader = new SAXReader();

		Document document;
		document = reader.read(new File(getClass().getClassLoader().getResource("antique.xml").getPath()));

		Element root = document.getRootElement();
		
		List<Element> element = root.elements();
		for(Element e : element){
			if(e.attribute("id").getStringValue().equals(id)){
				root.remove(e);
			}
		}
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File(getClass().getClassLoader().getResource("antique.xml").getPath())), format);
		xmlWriter.write(document);
	}
	
	public Antique findAntiqueById(String id) throws DocumentException {
		SAXReader reader = new SAXReader();
		Antique antique = new Antique();
		Document document;
		document = reader.read(new File(getClass().getClassLoader().getResource("antique.xml").getPath()));

		Element root = document.getRootElement();
		
		List<Element> elementlist = root.elements();
		for(Element element : elementlist){
			if(element.attribute("id").getStringValue().equals(id)){
				Attribute name = element.attribute("name");
				Attribute category = element.attribute("category");
				
				Element size = element.element("size");
				Element createtime = element.element("createtime");
				Element findtime = element.element("findtime");
				Element findplace = element.element("findplace");
				Element description = element.element("description");
				Element imgurl = element.element("imgurl");
				
				antique = new Antique(id,name.getStringValue(),category.getStringValue(),
												size.getStringValue(),createtime.getStringValue(),findtime.getStringValue(),
												findplace.getStringValue(),description.getStringValue(),imgurl.getStringValue());
				return antique;
			}
		}
		return antique;
	}
	
	public void modify(Antique antique){
		SAXReader reader = new SAXReader();

		Document document;
		try {
			document = reader.read(new File(getClass().getClassLoader().getResource("antique.xml").getPath()));
			Element root = document.getRootElement();
			
			List<Element> elementlist = root.elements("antique");
			
			for (Element element : elementlist) {
				String id = element.attribute("id").getStringValue();
				if(id.equals(antique.getId())){
					element.setAttributeValue("name", antique.getName());
					element.setAttributeValue("category", antique.getCategory());
					
					Element size = element.element("size");
					size.setText(antique.getSize());
					Element createtime = element.element("createtime");
					createtime.setText(antique.getCreatetime());
					Element findtime = element.element("findtime");
					findtime.setText(antique.getFindtime());
					Element findplace = element.element("findplace");
					findplace.setText(antique.getFindplace());
					Element description = element.element("description");
					description.setText(antique.getDescription());
					Element imgurl = element.element("imgurl");
					imgurl.setText(antique.getImgurl());
					break;
				}
			}
			
			OutputFormat format = OutputFormat.createPrettyPrint();  
            format.setEncoding("UTF-8");  
            XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(new File(getClass().getClassLoader().getResource("antique.xml").getPath())),format);
            xmlWriter.write(document);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Antique> search(String name,String category) {
		SAXReader reader = new SAXReader();
		List<Antique> list = new ArrayList<Antique>();
		Document document;
		try {
			document = reader.read(new File(getClass().getClassLoader().getResource("antique.xml").getPath()));
			Element root = document.getRootElement();
			
			List<Element> elementlist = root.elements();
			for(Element element : elementlist){
				if (!"".equals(name)) {
					Attribute aname = element.attribute("name");
					if (aname.getStringValue().contains(name)) {
						if (!"".equals(category)) {
							Attribute acategory = element.attribute("category");
							if (acategory.getStringValue().contains(category)) {
								Attribute id = element.attribute("id");

								Element size = element.element("size");
								Element createtime = element.element("createtime");
								Element findtime = element.element("findtime");
								Element findplace = element.element("findplace");
								Element description = element.element("description");
								Element imgurl = element.element("imgurl");

								Antique antique = new Antique(id.getStringValue(), aname.getStringValue(),
										acategory.getStringValue(), size.getStringValue(), createtime.getStringValue(),
										findtime.getStringValue(), findplace.getStringValue(), description.getStringValue(),
										imgurl.getStringValue());
								list.add(antique);
							}
						} else {
							Attribute id = element.attribute("id");
							Attribute acategory = element.attribute("category");
							Element size = element.element("size");
							Element createtime = element.element("createtime");
							Element findtime = element.element("findtime");
							Element findplace = element.element("findplace");
							Element description = element.element("description");
							Element imgurl = element.element("imgurl");

							Antique antique = new Antique(id.getStringValue(), aname.getStringValue(),
									acategory.getStringValue(), size.getStringValue(), createtime.getStringValue(),
									findtime.getStringValue(), findplace.getStringValue(), description.getStringValue(),
									imgurl.getStringValue());
							list.add(antique);
						}
					}
				}else if("".equals(category)){
					Attribute id = element.attribute("id");
					Attribute aname = element.attribute("name");
					Attribute acategory = element.attribute("category");
					Element size = element.element("size");
					Element createtime = element.element("createtime");
					Element findtime = element.element("findtime");
					Element findplace = element.element("findplace");
					Element description = element.element("description");
					Element imgurl = element.element("imgurl");

					Antique antique = new Antique(id.getStringValue(), aname.getStringValue(),
							acategory.getStringValue(), size.getStringValue(), createtime.getStringValue(),
							findtime.getStringValue(), findplace.getStringValue(), description.getStringValue(),
							imgurl.getStringValue());
					list.add(antique);
				}
				else{
					Attribute acategory = element.attribute("category");
					if (acategory.getStringValue().contains(category)) {
						Attribute id = element.attribute("id");
						Attribute aname = element.attribute("name");
						Element size = element.element("size");
						Element createtime = element.element("createtime");
						Element findtime = element.element("findtime");
						Element findplace = element.element("findplace");
						Element description = element.element("description");
						Element imgurl = element.element("imgurl");

						Antique antique = new Antique(id.getStringValue(), aname.getStringValue(),
								acategory.getStringValue(), size.getStringValue(), createtime.getStringValue(),
								findtime.getStringValue(), findplace.getStringValue(), description.getStringValue(),
								imgurl.getStringValue());
						list.add(antique);
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
