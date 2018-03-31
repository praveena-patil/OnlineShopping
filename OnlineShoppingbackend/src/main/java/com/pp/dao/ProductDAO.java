package com.pp.dao;

import java.util.List;

import com.pp.model.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();
	public Product getProduct(int id);
	void addProduct(Product product);
	void removeProduct(int id);
	void modifyProduct(Product product);
}
