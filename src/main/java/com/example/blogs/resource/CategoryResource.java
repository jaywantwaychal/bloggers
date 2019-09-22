package com.example.blogs.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogs.entities.CategoryEntity;
import com.example.blogs.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/allCategories")
	public List<CategoryEntity> getAllCategories() {
		
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public Optional<CategoryEntity> getCategory(@PathVariable("id") long category_id) {
		
		return categoryService.getCategory(category_id);
	}
	

	@PostMapping("/addCategory")
	public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
		return categoryService.addCategory(category);
	}
	
	@PutMapping("/updateCategory/{id}")
	public CategoryEntity updateCategory(@RequestBody CategoryEntity category, @PathVariable("id") long category_id ) {
		return categoryService.updateCategory(category, category_id);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public List<CategoryEntity> deleteCategory(@PathVariable ("id") long category_id) {
		return categoryService.deleteCategory(category_id);
	}
}
