package com.pp.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pp.dao.ProductDAO;
import com.pp.model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public Product getProduct(int id) {
		Product product = (Product) sessionFactory.getCurrentSession().get(Product.class,id);
		return product;
	}

	@Override
	public boolean addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	@Override
	public boolean removeProduct(int id) {
		Product product = getProduct(id);
		if (product != null)
			sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public boolean modifyProduct(Product product) {
		Product productToUpdate = getProduct(product.getId());
		productToUpdate.setName(product.getName());
		sessionFactory.getCurrentSession().update(productToUpdate);
		return true;
	}

}
