package com.weiweijin.myNoteAPI.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiweijin.myNoteAPI.Model.Category;
import com.weiweijin.myNoteAPI.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public List getCategoryByCategory(String category) {
		List<Category> categories = new ArrayList<>();
		Iterator<Category> iterator = categoryRepository.findAll().iterator();
		while (iterator.hasNext()) {
			Category c = iterator.next();
			if (c.getCategory().equals(category)) {
				categories.add(c);
			}
		}
		return categories;
	}
	
	public void deleteCategoryByID(Long id) {
		categoryRepository.deleteById(id);
	}
}
