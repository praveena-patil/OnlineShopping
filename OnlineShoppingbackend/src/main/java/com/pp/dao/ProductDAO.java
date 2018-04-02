package com.pp.dao;

import java.util.List;

import com.pp.model.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();
	public Product getProduct(int id);
	boolean addProduct(Product product);
	boolean removeProduct(int id);
	boolean modifyProduct(Product product);
}
