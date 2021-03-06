package com.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.model.Entry;
import com.example.model.Person;
import com.fasterxml.classmate.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFac;
	
	static {
		try {			
//			Configuration cfg = new Configuration();
//			cfg.configure(); //it will read the configuration file .xml (hibernate.cfg.xml)
//			ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//			sessionFac = cfg.buildSessionFactory(servReg); //fetch sessonfactory for our sessions
			
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Person.class);
			cfg.addAnnotatedClass(Entry.class);
			
			cfg.configure(); //it will read the configuration file .xml (hibernate.cfg.xml)
			ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sessionFac = cfg.buildSessionFactory(servReg); //fetch sessonfactory for our sessions

			
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}	
//		catch (HibernateException e) { throw new HibernateException(e);
	}
	
	public static Session getSession(){
		return sessionFac.openSession();		
	}

}
