package br.ufrn.dimap.consiste.resource;

import java.util.List;

public class SensorEntity {

	private String name;
	private List<String> properties;
	private String description;
	private String location;
	
	public SensorEntity(){
		
	}
	
	public SensorEntity(String name, List<String> properties, String description, String location) {
		this.name = name;
		this.properties = properties;
		this.description = description;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getProperties() {
		return properties;
	}
	
	public void setProperties(List<String> properties) {
		this.properties = properties;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}
