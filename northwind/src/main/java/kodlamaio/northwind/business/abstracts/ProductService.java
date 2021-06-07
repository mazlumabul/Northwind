package kodlamaio.northwind.business.abstracts;

import java.util.List;



import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted(); // sorted, data yı istediğim arta göre sıralasın
	DataResult<List<Product>> getAll(int pageNo,int  pageSize); // sayfalamak için
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	// select * from products where product_name = parametre ile gelen değer
	
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	// select * from products where product_name = parametre ile gelen değer AND categoryId
	
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	// select * from products where product_name = parametre ile gelen değer OR categoryId
	
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	//select * from where products category_id(1,2,3,4,5);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId);
	//select * from where products where product_name = bişey and categoryId=bişey;
	

}
