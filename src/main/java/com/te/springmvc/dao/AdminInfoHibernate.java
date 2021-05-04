package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.beans.*;
import com.te.springmvc.customexception.ProductException;
@Repository
public class AdminInfoHibernate implements AdminDao{
	//@PersistenceUnit
	EntityManagerFactory factory;
	
      @Override
	public AdminInfo  authenticate(int id, String password) {
    	  AdminInfo bean = null;
    	  
		try {
			factory = Persistence.createEntityManagerFactory("springdb");

			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			String query = "from AdminInfo where adminid=:id and adminpwd=:pwd";
			Query issuedQuery = manager.createQuery(query);
			issuedQuery.setParameter("id", id);
			issuedQuery.setParameter("pwd", password);
			transaction.begin();
			 bean = (AdminInfo) issuedQuery.getSingleResult();
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	@Override
	public List<Product> getAllProductDetails() {
		System.out.println("dao is executing ");
		List<Product> productbeans = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery(" from Product");
			productbeans = query.getResultList();
			for(Product beans:productbeans) {
				System.out.println(beans.getProductid());
				System.out.println(beans.getProductname());
			}
			
		} catch (Exception e) {
			productbeans = null;
			e.printStackTrace();
		}
		return productbeans;
		
	}
	@Override
	public boolean addproducts(Product product) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction trans = manager.getTransaction();
			
			manager.persist(product);
			trans.commit();
			return true;
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean updateProduct(Product product) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Product orgData = manager.find(Product.class ,product.getProductid());

			if (product.getProductname() != null && product.getProductname() != "") {
				orgData.setProductname(product.getProductname());
			}

			if (product.getProductprice() != 0 ) {
				orgData.setProductprice(product.getProductprice());
			}

			if (product.getQuantity() != 0) {
				orgData.setQuantity(product.getQuantity());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteProduct(int id) {
		try {
    		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Product infoBean = manager.find(Product.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new ProductException("The Data is not present");
		}
	}
}
