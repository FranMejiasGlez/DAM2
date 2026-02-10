package pruebaHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil{
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			Configuration cfg=new Configuration().configure();
			sessionFactory= cfg.buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Falló la creación de SessionFactory inicial."+ex);
			throw new ExceptionInInitializerError(ex);
	
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}