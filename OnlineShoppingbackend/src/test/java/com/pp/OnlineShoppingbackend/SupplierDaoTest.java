package com.pp.OnlineShoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pp.dao.SupplierDAO;
import com.pp.model.Supplier;

public class SupplierDaoTest {
	private static AnnotationConfigApplicationContext context;
	private static SupplierDAO supplierDao;
	private Supplier supplier;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.pp");
		context.refresh();
		supplierDao = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Ignore
	@Test
	public void AddSupplier() {
		supplier = new Supplier();
		// supplier.setSupplier_id();
		supplier.setSupplier_name("Patil");
		assertEquals("Successfully added a supplier details into the table",
				true, supplierDao.addSupplier(supplier));
	}

	 @Ignore
	@Test
	public void GetSupplier() {
		supplier = supplierDao.getSupplier(33);
		assertEquals("Successfully fetched a supplier details from the table",
				"Praveena", supplier.getSupplier_name());
		System.out
				.println("<===================Got the details===============> :\n Supplier name :"
						+ supplier.getSupplier_name());
	}

	@Ignore
	@Test
	public void removeSupplier() {
		supplier = supplierDao.getSupplier(1);
		assertEquals("Successfully updated a supplier details from the table",
				true, supplierDao.removeSupplier(1));
	}

	@Ignore
	@Test
	public void modifySupplier() {
		assertEquals("Successfully deleted supplier details from the table",
				true, supplierDao.modifySupplier(supplier));
	}

	//@Ignore
	@Test
	public void testGetAllSupplier() {
		assertEquals(
				"Successfully fetched all supplier details from the table", 2,
				supplierDao.getAllSupplier().size());
		System.out.println("<=========All suppliers count:"+supplierDao.getAllSupplier().size());
	}
}