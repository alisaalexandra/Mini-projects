package com.service;

import com.exceptions.CategoryNotFoundException;
import com.persistence.dao.ProductDao;
import com.persistence.model.CategoryModel;
import com.persistence.model.ProductModel;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {
    private ProductDao productDao = new ProductDao();

    public List<ProductModel> getAllProducts(){
        return productDao.getAll();
    }

    public void addProduct(ProductModel productModel){
        List<ProductModel> all = productDao.getAll();
        int size = all.size();
        if (size == 0) {
            productModel.setId(Integer.toString(1));
        } else {
            productModel.setId(Integer.toString(size+1));
        }
        productDao.add(productModel);
    }

    public Optional<ProductModel> getProductById(String id) {
        try{
            return productDao.findById(id);
        } catch (CategoryNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<ProductModel> getProductsOrderByName(){
        return productDao.getAll().stream().sorted(Comparator.comparing(parameter -> parameter.getName())).collect(Collectors.toList());
    }

    public void removeProduct(String id) {
        productDao.remove(id);
    }

    public void updatProduct(ProductModel productModel){
        removeProduct(productModel.getId());
        addProduct(productModel);
    }

}
