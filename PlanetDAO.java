package com.wolken.SolarSystem.dao;


import com.wolken.SolarSystem.entity.PlanetEntity;
public interface PlanetDAO {
	 String save(PlanetEntity entity);
	    void getById(int id);
	    String update(PlanetEntity entity);
	    String delete(int id);
}
