package com.project.sejmet.controllers;

import com.project.sejmet.entities.Category;
import com.project.sejmet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categories")

public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping
    public List<Category> getCategoryAll() {
        return categoryRepository.findAll();
    }


    @GetMapping("/{id}")
    public Category getCategorybyId(@PathVariable int id) {

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            return category.get();
        }

        return null;
    }


    @PostMapping
    public Category postCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return category;
    }


    @PutMapping("/{id}")
    public Category putCategorybyId(@PathVariable int id, @RequestBody Category category) {

        Optional<Category> categoryCurrent = categoryRepository.findById(id);

        if (categoryCurrent.isPresent()) {
            Category categoryReturn = categoryCurrent.get();

            categoryReturn.setCategoryName(category.getCategoryName());
            categoryReturn.setCategoryDescripton(category.getCategoryDescripton());

            categoryRepository.save(categoryReturn);
            return categoryReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Category deleteCategorybyId(@PathVariable int id) {

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            Category categoryReturn = category.get();
            categoryRepository.deleteById(id);
            return categoryReturn;
        }

        return null;
    }
}
