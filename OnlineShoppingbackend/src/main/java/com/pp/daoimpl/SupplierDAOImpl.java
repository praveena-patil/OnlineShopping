package com.pp.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pp.dao.SupplierDAO;
import com.pp.model.Supplier;

@Repository(value = "supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getAllSupplier() {
		return getCurrentSession().createQuery("from Supplier").list();
	}

	@Override
	public Supplier getSupplier(int id) {
		Supplier supplier = (Supplier) getCurrentSession().get(Supplier.class,
				id);
		return supplier;
	}

	@Override
	public boolean addSupplier(Supplier supplier) {
		getCurrentSession().save(supplier);
		return true;
	}

	@Override
	public boolean removeSupplier(int id) {
		Supplier supplier = getSupplier(id);
		if (supplier != null) {
			getCurrentSession().delete(supplier);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifySupplier(Supplier supplier) {
		Supplier supplierToUpdate = getSupplier(supplier.getSupplier_id());
		supplierToUpdate.setSupplier_name(supplier.getSupplier_name());
		getCurrentSession().update(supplierToUpdate);
		return true;
	}

}
