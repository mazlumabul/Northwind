package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	Product getByProductName(String productName);
	// select * from products where product_name = parametre ile gelen değer
	
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	// select * from products where product_name = parametre ile gelen değer AND categoryId
	
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	// select * from products where product_name = parametre ile gelen değer OR categoryId
	
	
	List<Product> getByCategoryIn(List<Integer> categories);
	//select * from where products category_id(1,2,3,4,5);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName =: productName and category.categoryId =: categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	//select * from where products where product_name = bişey and categoryId=bişey;
}
