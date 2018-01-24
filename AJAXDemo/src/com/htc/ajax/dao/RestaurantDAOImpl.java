package com.htc.ajax.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.htc.ajax.dto.RestaurantDTO;

public class RestaurantDAOImpl  implements RestaurantDAO{

	@Override
	public void insertData(RestaurantDTO rest) {
		System.out.println("insert Data");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("restDB");
		EntityManager entityManager=factory.createEntityManager();
		EntityTransaction trans=entityManager.getTransaction();
		trans.begin();
		try{
			entityManager.persist(rest);
			System.out.println("Data Saved");
			trans.commit();
		}
		catch(Exception e){
			trans.rollback();
		}
	}

	@Override
	public RestaurantDTO getData(int restId) {
		RestaurantDTO rest=null;
		System.out.println("inside getData");
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("restDB");
		EntityManager entityManager=factory.createEntityManager();
		EntityTransaction trans=entityManager.getTransaction();
		trans.begin();
		try{
			rest=(RestaurantDTO)entityManager.find(RestaurantDTO.class,restId);
			System.out.println("Data returned successfully");
			trans.commit();
		}
		catch(Exception e){
			trans.rollback();
		}
		return rest;
	}

	
}
