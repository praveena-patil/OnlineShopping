package com.pp.dao;

import java.util.List;

import com.pp.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> getAllSupplier();
	public Supplier getSupplier(int id);
	void addSupplier(Supplier supplier);
	void removeSupplier(int id);
	void modifySupplier(Supplier supplier);
}
