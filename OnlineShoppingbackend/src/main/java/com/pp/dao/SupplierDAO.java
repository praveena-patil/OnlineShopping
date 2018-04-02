package com.pp.dao;

import java.util.List;

import com.pp.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> getAllSupplier();
	public Supplier getSupplier(int id);
	boolean addSupplier(Supplier supplier);
	boolean removeSupplier(int id);
	boolean modifySupplier(Supplier supplier);
}
