package com.antique.domain;

public class Antique {
	
	private String id;
	private String name;
	private String category;
	private String size;
	private String createtime;
	private String findtime;
	private String findplace;
	private String description;
	private String imgurl;
	
	
	public Antique() {
		super();
	}
	public Antique(String id, String name, String category, String size, String createtime, String findtime,
			String findplace, String description, String imgurl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.size = size;
		this.createtime = createtime;
		this.findtime = findtime;
		this.findplace = findplace;
		this.description = description;
		this.imgurl = imgurl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getFindtime() {
		return findtime;
	}
	public void setFindtime(String findtime) {
		this.findtime = findtime;
	}
	public String getFindplace() {
		return findplace;
	}
	public void setFindplace(String findplace) {
		this.findplace = findplace;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
}
