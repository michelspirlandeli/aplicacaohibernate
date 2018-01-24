package br.michel.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

	  private static final long serialVersionUID = 1L;
	    private static HibernateUtil me;
	    private SessionFactory sessionFactory;
	    
	    private HibernateUtil(){
	        sessionFactory = new AnnotationConfiguration()
	                    .setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect")
	                    .setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.ClientDriver")
	                    .setProperty("hibernate.connection.url", "jdbc:derby://localhost:3306/db_aplicacaohibernate")
	                    .setProperty("hibernate.connection.username", "root")
	                    .setProperty("hibernate.connection.password", "root")
	                    .setProperty("hibernate.hbm2ddl.auto", "none")
	                    .setProperty("hibernate.show_sql", "true")
	                    .setProperty("hibernate.format_sql", "true")
	                    .setProperty("hibernate.c3p0.acquire_increment", "1")
	                    .setProperty("hibernate.c3p0.idle_test_period", "100")
	                    .setProperty("hibernate.c3p0.max_size", "10")
	                    .setProperty("hibernate.c3p0.max_statements", "0")
	                    .setProperty("hibernate.c3p0.min_size", "5")
	                    .setProperty("hibernate.c3p0.timeout", "100")
	                    .addAnnotatedClass(User.class)
	                    .addAnnotatedClass(Product.class)
	                    .addAnnotatedClass(Sale.class)
	                    .buildSessionFactory();
	        }


	        public Session getSession() {
	            Session toReturn = sessionFactory.openSession();
	            toReturn.beginTransaction();
	            return toReturn;
	        }


	        public static HibernateUtil getInstance() {
	            if (me== null){
	                me = new HibernateUtil();
	            }
	            return me;
	        }

}
