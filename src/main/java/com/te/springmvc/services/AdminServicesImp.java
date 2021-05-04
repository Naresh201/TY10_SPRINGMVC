package com.te.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.beans.AdminInfo;
import com.te.springmvc.beans.Product;
import com.te.springmvc.dao.AdminDao;

@Service
public class AdminServicesImp implements AdminSevices{
	@Autowired
	AdminDao dao;

	public AdminInfo autheticate(int id, String password) {
		return dao.authenticate(id, password);
		
	}

	@Override
	public List<Product> getAllProductDetails() {
		System.out.println("service is executing");
		
		return dao.getAllProductDetails();
	}

	@Override
	public boolean addProducts(Product product) {
		
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.addproducts(product);
	}

	@Override
	public boolean deleteProduct(int  id) {
		
		return dao.deleteProduct(id);
	}

}
