package com.ozansaribal.springboot;

import com.ozansaribal.springboot.entity.Category;
import com.ozansaribal.springboot.entity.Product;
import com.ozansaribal.springboot.service.entityservice.CategoryEntityService;
import com.ozansaribal.springboot.service.entityservice.ProductEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class N11BootcampWeek3TrialApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(N11BootcampWeek3TrialApp.class, args);

		CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
		ProductEntityService productEntityService = applicationContext.getBean(ProductEntityService.class);

//		Category category = getTelephoneCategory(service);

//		getSamsungM31(categoryEntityService, productEntityService);

//		deleteProductList(productEntityService);

//		findAllProductList(productEntityService);

//		saveBook(categoryEntityService);

//		findAllProductList(categoryEntityService);
	}

	private static void saveBook(CategoryEntityService categoryEntityService) {
		Category book = new Category();
		book.setName("Book");
		book.setRefraction(1L);

		book = categoryEntityService.save(book);

		Category bookBelow = new Category();
		bookBelow.setRefraction(2L);
		bookBelow.setName("Book");
		bookBelow.setTopCategory(book);

		categoryEntityService.save(bookBelow);
	}

	private static void findAllProductList(ProductEntityService productEntityService) {
		List<Product> productList = productEntityService.findAll();

		for (Product product : productList) {
			System.out.println(product.getName());
		}
	}

	private static void findAllProductList(CategoryEntityService categoryEntityService) {
		List<Category> categoryList = categoryEntityService.findAll();

		for (Category category : categoryList) {
			System.out.println(category.getName());
		}
	}

	private static void deleteProductList(ProductEntityService productEntityService) {
		List<Long> toBeDeleteIdList = Arrays.asList(102L, 152L, 202L, 252L, 302L);

		for (Long productId : toBeDeleteIdList) {
			productEntityService.deleteById(productId);
		}
	}

	private static void getSamsungM31(CategoryEntityService categoryEntityService, ProductEntityService productEntityService) {
		Category category = categoryEntityService.findById(502L);

		Product product = new Product();
		product.setName("Samsung M31");
		product.setPrice(new BigDecimal("3000"));
		product.setRegisterDate(new Date());
		product.setCategory(category);

		product = productEntityService.save(product);

		System.out.println(product);
	}

	private static Category getTelephoneCategory(CategoryEntityService service) {
		Category topCategory = service.findById(2L);

		System.out.println(topCategory);

		Category category = new Category();
		category.setName("Telephone");
		category.setRefraction(2L);
		category.setTopCategory(topCategory);

		category = service.save(category);

		System.out.println(category);

		return category;
	}

}
