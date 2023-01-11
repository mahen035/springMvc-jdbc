package com.training.springmvc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.springmvc.model.Product;
import com.training.springmvc.model.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_PRODUCT = "select * from product where prod_id = ?";
	private final String SQL_GET_PRODUCTS = "select * from product";
	private final String SQL_CREATE_PRODUCT = "insert into product"
									+ "	(prod_id, prod_name, prod_desc, price) "	
										+"values(?,?,?,? )";
	
	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Product getProductById(int id) {
		
		return jdbcTemplate.queryForObject(SQL_FIND_PRODUCT, new Object[] {id}, new ProductMapper());
	}

	@Override
	public List<Product> getProducts() {
		
		return jdbcTemplate.query(SQL_GET_PRODUCTS, new ProductMapper());
	}

	@Override
	public boolean createProduct(Product product) {
		
		return jdbcTemplate.update(SQL_CREATE_PRODUCT, product.getProdId(), product.getProdName()
				, product.getProdDesc(), product.getPrice()) > 0;
	}

}
