package com.persistence.dao;

import com.persistence.model.CategoryModel;

public class CategoryDao extends ModelDao<CategoryModel> {

    public CategoryDao() {
        super("category.txt");
    }

}
