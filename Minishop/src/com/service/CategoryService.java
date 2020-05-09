package com.service;

import com.exceptions.CategoryNotFoundException;
import com.persistence.dao.CategoryDao;
import com.persistence.model.CategoryModel;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<CategoryModel> getAllCategories() {
        return categoryDao.getAll();
    }

    public void addCategory(CategoryModel categoryModel) {
        List<CategoryModel> all = categoryDao.getAll();
        int size = all.size();
        if (size == 0) {
            categoryModel.setId(Integer.toString(1));
        } else {
            categoryModel.setId(Integer.toString(size+1));
        }
        categoryDao.add(categoryModel);
    }

    public Optional<CategoryModel> getCategoryById(String id) {
        try {
            return categoryDao.findById(id);
        }catch (CategoryNotFoundException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<CategoryModel> getCategoriesOrderByName() {
        List<CategoryModel> list = categoryDao.getAll();
        return list.stream().sorted(Comparator.comparing(parameter -> parameter.getName())).collect(Collectors.toList());
    }

    public void removeCategory(String id) {
            categoryDao.remove(id);
    }

    public void updateCategory(CategoryModel categoryModel) {
        removeCategory(categoryModel.getId());
        addCategory(categoryModel);
    }
}
