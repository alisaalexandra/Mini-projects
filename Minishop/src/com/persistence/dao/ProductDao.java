package com.persistence.dao;

import com.persistence.model.ProductModel;

public class ProductDao extends ModelDao<ProductModel> {
    public ProductDao() {
        super("product.txt");
    }
}
