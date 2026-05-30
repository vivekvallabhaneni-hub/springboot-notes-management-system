package com.example.Noteproject.Sevice;

import com.example.Noteproject.DTOS.CategoryRequest;
import com.example.Noteproject.DTOS.CategoryResponse;
import com.example.Noteproject.Entity.Category;
import com.example.Noteproject.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo repo;

    public CategoryResponse saveCategory(CategoryRequest req){
        Category cat = new Category();
        cat.setName(req.getName());
        cat.setColor(req.getColor());
        Category savedCategory = repo.save(cat);
        CategoryResponse response = new CategoryResponse();
        response.setId(savedCategory.getId());
        response.setName(savedCategory.getName());
        response.setColor(savedCategory.getColor());
        return response;
    }

    public List<CategoryResponse> getAllCategory() {

        return repo.findAll()
                .stream()
                .map(cat -> {
                    CategoryResponse response = new CategoryResponse();

                    response.setId(cat.getId());
                    response.setName(cat.getName());
                    response.setColor(cat.getColor());

                    return response;
                })
                .toList();
    }
    public CategoryResponse getCategoryById(Integer id) {

        Category cat = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        CategoryResponse res = new CategoryResponse();

        res.setId(cat.getId());
        res.setName(cat.getName());
        res.setColor(cat.getColor());

        return res;
    }
    public String deleteCategoryById(Integer id){
        Category cat = repo.findById(id)
                .orElseThrow(()->new RuntimeException("category Not found"));
        repo.delete(cat);
        return "Deleted SuccessFully";
    }
}
