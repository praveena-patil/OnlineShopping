package com.pp.OnlineShoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pp.dao.CategoryDAO;
import com.pp.model.Category;

public class CategoryDaoTest {
private Category cat;
private static CategoryDAO catDao;


@BeforeClass
public static void initialze(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.pp");
	context.refresh();
	catDao = (CategoryDAO) context.getBean("categoryDAO");
	
}

	@Ignore
	@Test
	public void insertCategorytest() {
    cat=new Category();
    cat.setCategory_name("Mobiles");
    assertEquals("Category insert failure",true,catDao.addCategory(cat));
	}
	//@Ignore
	@Test
	public void updateCategoryTest(){
		cat=new Category();
		cat.setCategory_name("Electronics");
		 assertEquals("Category insert failure",true,catDao.modifyCategory(cat));
	}
	
	@Test
	public void getCategoryTest(){
		cat=catDao.getCategory(2);
				assertEquals("Category insert failure","Mobiles",cat.getCategory_name());
				System.out.println("<=================Category Details======================>");
				System.out.println("category ID:"+cat.getCategory_id());
				System.out.println("category name:"+cat.getCategory_name());
	}

}
