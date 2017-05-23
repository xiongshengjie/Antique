package com.antique.service;

import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;

import com.antique.dao.AntiqueDao;
import com.antique.domain.Antique;

public class AntiqueService {

	private AntiqueDao dao = new AntiqueDao();
	
	public List<Antique> listAll() throws DocumentException {
		return dao.listAll();
	}
	
	public void add(Antique antique) throws IOException, DocumentException {
		dao.add(antique);
	}
	
	public void del(String id) throws DocumentException, IOException {
		dao.del(id);
	}
	
	public void modify(Antique antique) {
		dao.modify(antique);
	}
	
	public Antique findAntiqueById(String id) throws DocumentException {
		return dao.findAntiqueById(id);
	}
	
	public List<Antique> findAntiqueByMany(String name , String category) {
		return dao.search(name, category);
	}
}
