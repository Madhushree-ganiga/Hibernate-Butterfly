package com.wolken.SolarSystem.dao;

import com.wolken.SolarSystem.entity.PlanetEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.wolken.SolarSystem.entity.PlanetEntity;
import com.wolken.SolarSystem.utils.HibernateUtils;

public class PlanetDAOImpl implements PlanetDAO {
	public String save(PlanetEntity entity) {
        Session session = null;
        SessionFactory factory;
        try {
            factory = HibernateUtils.getFactory();
            session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return "Details of the planet saved";
    }
	public void getById(int id) {
        Session session = null;
        SessionFactory factory;
        try {
            factory = HibernateUtils.getFactory();
            session = factory.openSession();
            PlanetEntity entity = session.get(PlanetEntity.class, id);
            System.out.println(entity);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	public String update(PlanetEntity entity) {
		Session session = null;
        SessionFactory factory;
        try {
            factory = HibernateUtils.getFactory();
            session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("update PlanetEntity set name = '" +
                    entity.getName() + "' where id=" + entity.getId());
            session.clear();
            query.executeUpdate();
//            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return "Details of the planet updated";
    }

	
	public String delete(int id) {
        Session session = null;
        SessionFactory factory;
        try {
            factory = HibernateUtils.getFactory();
            session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            PlanetEntity entity = session.get(PlanetEntity.class, id);
            session.delete(entity);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return "Details of the planet deleted";
    }
}