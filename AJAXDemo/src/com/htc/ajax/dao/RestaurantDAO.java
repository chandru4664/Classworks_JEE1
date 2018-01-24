package com.htc.ajax.dao;
import com.htc.ajax.dto.RestaurantDTO;
public interface RestaurantDAO {
	public void insertData(RestaurantDTO rest);
	public RestaurantDTO getData(int restId);

}
