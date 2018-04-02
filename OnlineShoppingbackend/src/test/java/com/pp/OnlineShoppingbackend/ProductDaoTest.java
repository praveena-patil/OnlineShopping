package com.pp.OnlineShoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pp.dao.CategoryDAO;
import com.pp.dao.ProductDAO;
import com.pp.model.Category;
import com.pp.model.Product;

public class ProductDaoTest {
	private Product product;
	private static ProductDAO productDao;
	
	@BeforeClass
	public static void initialze(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.pp");
		context.refresh();
		productDao = (ProductDAO) context.getBean("productDAO");
		
	}

		@Ignore
		@Test
		public void addProducttest() {
		product=new Product();
		product.setName("Asus");
	    assertEquals("Productinsert failure",true,productDao.addProduct(product));
		}
		@Ignore
		@Test
		public void removeeProductTest(){
			product=new Product();
			product.setName("Electronics");
			 assertEquals("Category insert failure",true,productDao.modifyProduct(product));
		}
		@Ignore
		@Test
		public void modifyProductTest(){
			product=productDao.getProduct(2);
					assertEquals("Product insert failure","Mobiles",product.getName());
					System.out.println("<=================Product Details======================>");
					System.out.println("product ID:"+product.getId());
					System.out.println("product name:"+product.getName());
		}

	}

