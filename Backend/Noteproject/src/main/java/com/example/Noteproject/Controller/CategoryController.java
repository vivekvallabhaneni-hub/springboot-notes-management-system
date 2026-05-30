package com.example.Noteproject.Controller;

import com.example.Noteproject.DTOS.CategoryRequest;
import com.example.Noteproject.DTOS.CategoryResponse;
import com.example.Noteproject.Sevice.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/save")
    public CategoryResponse saveCategory(
            @RequestBody CategoryRequest req) {

        return service.saveCategory(req);
    }

    @GetMapping("/all")
    public List<CategoryResponse> getAllCategories() {

        return service.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(
            @PathVariable Integer id) {

        return service.getCategoryById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(
            @PathVariable Integer id) {
        return service.deleteCategoryById(id);
    }
}