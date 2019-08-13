package com.weiweijin.myNoteAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weiweijin.myNoteAPI.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
