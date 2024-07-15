package com.cg.onlinesweetmart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.onlinesweetmart.entity.Category;
import com.cg.onlinesweetmart.entity.Product;
import com.cg.onlinesweetmart.exception.SweetMartAPIException;
import com.cg.onlinesweetmart.repository.CategoryRepository;
import com.cg.onlinesweetmart.repository.ProductRepository;
import com.cg.onlinesweetmart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Add a new product to a specific category.
     *
     * @param product the product to be added
     * @param categoryId the ID of the category
     * @return the saved product
     */
    @Override
    public Product addProduct(Product product, int categoryId) {
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
        if (!categoryOpt.isPresent()) {
            throw new SweetMartAPIException(HttpStatus.NOT_FOUND, "Category not found with id " + categoryId);
        }
        Category category = categoryOpt.get();
        product.setCategory(category);
        return productRepository.save(product);
    }

    /**
     * Update an existing product.
     *
     * @param product the product to be updated
     * @return the updated product
     */
    @Override
    public Product updateProduct(Product product) {
        // Check if the product exists
        if (!productRepository.existsById(product.getProductId())) {
            throw new SweetMartAPIException(HttpStatus.NOT_FOUND, "Product not found with id " + product.getProductId());
        }
        return productRepository.save(product);
    }

    /**
     * Delete a product by its ID.
     *
     * @param productId the ID of the product to be deleted
     */
    @Override
    public void cancelProduct(int productId) {
        if (!productRepository.existsById(productId)) {
            throw new SweetMartAPIException(HttpStatus.NOT_FOUND, "Product not found with id " + productId);
        }
        productRepository.deleteById(productId);
    }

    /**
     * Retrieve all products.
     *
     * @return list of all products
     */
    @Override
    public List<Product> showAllProduct() {
        return productRepository.findAll();
    }

    /**
     * Retrieve products by category ID.
     *
     * @param categoryId the ID of the category
     * @return list of products in the specified category
     */
    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId);
    }
}

//@Service
//public class ProductServiceImpl {
//	
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	public Product addProduct(Product product, int categoryId) {
//		Category category = categoryRepository.findById(categoryId).get();
//		product.setCategory(category);
//		return productRepository.save(product);
//	}
//	
//	public Product updateProduct(Product product) {
//		return productRepository.save(product);
//	}
//	
//	public void cancelProduct(int productId) {
//		productRepository.deleteById(productId);;
//	}
//	
//	public List<Product> showAllProduct() {
//		return productRepository.findAll();
//	}
//
//	public List<Product> getProdyctByCategoryId(int categoryId) {
//		return productRepository.findByCategoryCategoryId(categoryId);
//	}
//}
