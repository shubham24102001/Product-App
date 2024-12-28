package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;

import oracle.net.aso.p;
import productcrudapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create..
	@Transactional
	public void createProduct(Product product) {
		hibernateTemplate.saveOrUpdate(product);
	}
	
	//get All product..
	public List<Product> getAllProducts(){
		List<Product> list=hibernateTemplate.loadAll(Product.class);
		return list;
	}
	
	//Delete the single product..
	
	@Transactional
	public void deleteProduct(int id) {
	Product p=hibernateTemplate.load(Product.class,id);
	
	hibernateTemplate.delete(p);
	}
	
	//get single product
	
	public Product getProduct(int id) {
		return hibernateTemplate.get(Product.class, id);
	}

}
