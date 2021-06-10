package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

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
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(p.id, p.productName, c.categoryName) "
			+ "From Category c inner join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	// select p.product_id, p.product_name, c.category_name from Category c inner join Product p
	// on c.categoryId = p.categoryId
	
	
	
}
