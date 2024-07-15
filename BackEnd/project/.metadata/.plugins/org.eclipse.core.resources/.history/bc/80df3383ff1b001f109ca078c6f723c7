package com.cg.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinesweetmart.entity.Category;
import com.cg.onlinesweetmart.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryServiceImpl.addCategory(category);
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/{id}")
	public Category showCategory(@PathVariable (value = "id") int categoryId) {
		return categoryServiceImpl.showCategory(categoryId);
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping
	public List<Category> showAllCategory() {
		return categoryServiceImpl.showAllCategory();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public Category updateCategory(@RequestBody Category category) {
		return categoryServiceImpl.updateCategory(category);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public String cancelCategory(@PathVariable (value = "id") int categoryId) {
		categoryServiceImpl.cancelCategory(categoryId);
		return "deleted";
	}
}
