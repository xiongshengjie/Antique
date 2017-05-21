package com.antique.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.antique.domain.Antique;

public class AntiqueDao {

	public List<Antique> listAll() throws DocumentException {
		SAXReader reader = new SAXReader();
		
		List<Antique> list = new ArrayList<Antique>();
		Antique antique;
		Document document = reader.read(new File("src/antique.xml"));
		
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
	
	public void add(Antique antique) {
		
	}
	
}
