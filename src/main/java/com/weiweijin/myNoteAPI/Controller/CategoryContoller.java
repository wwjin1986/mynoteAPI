package com.weiweijin.myNoteAPI.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weiweijin.myNoteAPI.Model.Category;
import com.weiweijin.myNoteAPI.repository.CategoryRepository;

@RestController
public class CategoryContoller {
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/categories")
	public List getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/categories")
	public Category addCategory(@Valid @RequestBody Category category) {
		return categoryRepository.save(category);
	}
}
