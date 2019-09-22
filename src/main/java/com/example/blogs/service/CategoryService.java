package com.example.blogs.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogs.entities.CategoryEntity;
import com.example.blogs.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<CategoryEntity> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public CategoryEntity addCategory(CategoryEntity category) {
		category.setCreation_date(Calendar.getInstance().getTime());
		return categoryRepository.save(category);
	}
	
	public Optional<CategoryEntity> getCategory(long category_id) {               
		return categoryRepository.findById(category_id);
	}

	public CategoryEntity updateCategory(CategoryEntity category, long category_id) {
		
		Optional<CategoryEntity> categoryToUpdate = categoryRepository.findById(category_id);
		
		if(categoryToUpdate.isPresent()) {
			
			CategoryEntity updatedCategory = categoryToUpdate.get();
			updatedCategory.setCategory_details(category.getCategory_details());
			updatedCategory.setCategory_name(category.getCategory_name());
			
			return categoryRepository.save(updatedCategory);
		}
		return null; 

	}

	public List<CategoryEntity> deleteCategory(long category_id) {
		
		if(categoryRepository.existsById(category_id)) {
			categoryRepository.deleteById(category_id);
		}
		return getAllCategories();
	}
}
