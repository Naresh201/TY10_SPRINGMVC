package com.te.springmvc.services;

import java.util.List;

import com.te.springmvc.beans.AdminInfo;
import com.te.springmvc.beans.Product;

public interface AdminSevices {
	
	public AdminInfo autheticate(int id,String password);
	public List<Product> getAllProductDetails(); 
	
	public boolean addProducts(Product product);
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(int id );

}
