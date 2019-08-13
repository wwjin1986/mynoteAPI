package com.weiweijin.myNoteAPI.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weiweijin.myNoteAPI.Model.Category;
import com.weiweijin.myNoteAPI.Service.CategoryService;
import com.weiweijin.myNoteAPI.repository.CategoryRepository;

@RestController
public class CategoryContoller {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, value ="/")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/categories")
	public List getAllCategories() {
		return categoryService.getAllCategories();
	}
	@RequestMapping(method = RequestMethod.POST, value ="/categories")
	public Category addCategory(@Valid @RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/categories/{category}")
	public List getCategorybyCategory(@PathVariable String category) {
		return categoryService.getCategoryByCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
	public void deleteCategoryByID(@PathVariable Long id) {
		categoryService.deleteCategoryByID(id);
	}
	
}
