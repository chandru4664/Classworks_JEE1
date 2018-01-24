package com.htc.ajax.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                      // to specify this class is an entity in database
@Table(name="Restaurant")    // only when your table name is not same as class name
public class RestaurantDTO implements Serializable {
	
	@Id       				// making a property as a primary key
	@Column   				// specifying that this property is a column in Table
	private int restId;
	@Column
	private String restName;
	@Column
	private String location;
	
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDTO(int restId, String restName, String location) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.location = location;
	}
	@Override
	public String toString() {
		return "RestaurantDTO [restId=" + restId + ", restName=" + restName
				+ ", location=" + location + "]";
	}
	
	

}
