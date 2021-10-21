package com.wolken.store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wolken.store.entity.MarketDetails;
public class TestMarket {
	public static void main(String[] args) {
		
		
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			SessionFactory factory=configuration.buildSessionFactory();
			Session session=factory.openSession();
			MarketDetails details = (MarketDetails)session.get(MarketDetails.class, 1);
			System.out.println(details);
		
			session.close();
			factory.close();
		}
	}


