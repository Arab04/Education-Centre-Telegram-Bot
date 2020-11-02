package com.Project.Tester2.hibernate;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.Project.Tester2.Enrollment;

public class Connection {
	
	private static SessionFactory session() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Enrollment.class);
		SessionFactory sf = con.buildSessionFactory();
		return sf;
	}
	
	public static void saveData(Enrollment en) {
		Session ss = session().openSession();
		Transaction tr = ss.beginTransaction();
		ss.saveOrUpdate(en);
		tr.commit();
		ss.close();
	}
	
	public static List<Enrollment> getData() {
		Session session = session().openSession();
		Transaction tr = session.beginTransaction();
		tr.commit();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Enrollment> query = builder.createQuery(Enrollment.class);
        Root<Enrollment> root = query.from(Enrollment.class);
        query.select(root);
        Query q=session.createQuery(query);
        List<Enrollment> enroll = q.getResultList();
        return enroll;
        
	}
	
	public static void main(String [] args) {
		getData();
	} 
	
	
}
