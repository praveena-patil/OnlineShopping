package com.pp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pp.dao.SupplierDAO;
import com.pp.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() 
	{
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAllSupplier() {
		return getCurrentSession().createQuery("from Supplier").list();
	}

	@Override
	public Supplier getSupplier(int id) {
		Supplier supplier = (Supplier) getCurrentSession().get(Supplier.class,id);
		return supplier;
	}

	@Override
	public void addSupplier(Supplier supplier) {
		getCurrentSession().save(supplier);
	}

	@Override
	public void removeSupplier(int id) {
		Supplier supplier = getSupplier(id);
		if (supplier != null)
			getCurrentSession().delete(supplier);
	}

	@Override
	public void modifySupplier(Supplier supplier) {
		Supplier supplierToUpdate = getSupplier(supplier.getSupplier_id());
		supplierToUpdate.setSupplier_name(supplier.getSupplier_name());
		getCurrentSession().update(supplierToUpdate);
	}

}
