package com.ui;

import com.persistence.dao.ObjectFileScanner;
import com.persistence.model.ProductModel;
import com.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductUI {
    private ProductService productService = new ProductService();
    private Scanner scanner = new Scanner(System.in);

    public void startProductManagement(){
        int option = -1;
        while(option!=7) {
            System.out.println("---Product Management---" +
                    "\n1.View products" +
                    "\n2.Find product by id" +
                    "\n3.View ordered products" +
                    "\n4.Update existing product" +
                    "\n5.Add new product" +
                    "\n6.Remove product" +
                    "\n7.Exit");
            option=scanner.nextInt();
            scanner.nextLine();
            if(option==1){
                viewProducts();
            }else if(option==2){
                findProductById();
            }else if(option==3){
                viewOrderedProducts();
            }else if(option==4){
                viewProducts();
                updateProduct();
            }else if(option==5){
                addProduct();
            }else if(option==6) {
                viewProducts();
                removeProduct();
            }
        }
    }

    public void viewProducts(){
        List<ProductModel> products = productService.getAllProducts();
        products.stream().forEach(parameter -> System.out.println( parameter.getId()+" - > " + parameter.getName() + " " + parameter.getPrice() +"x" +  parameter.getQuantity()));
    }

    public void findProductById(){
        System.out.println("Enter ID: ");
        Optional<ProductModel> optional = productService.getProductById(scanner.next());
        System.out.println(optional.get().getId() + " " + optional.get().getName() + " " + optional.get().getPrice() + "x" + optional.get().getQuantity());
    }

    public void viewOrderedProducts(){
        List<ProductModel> products = productService.getProductsOrderByName();
        products.stream().forEach(parameter -> System.out.println( parameter.getId()+" - > " + parameter.getName() + " " + parameter.getPrice() +"x" +  parameter.getQuantity()));
    }

    public void updateProduct(){
        ProductModel productModel = new ProductModel();
        System.out.println("Enter ID: ");
        productModel.setId(scanner.next());
        System.out.println("Enter product new name: ");
        productModel.setName(scanner.next());
        System.out.println("Enter product price: ");
        productModel.setPrice(new BigDecimal(scanner.nextInt()));
        System.out.println("Enter product quantity: ");
        productModel.setQuantity(scanner.nextInt());
        productService.updatProduct(productModel);
    }

    public void addProduct(){
        ProductModel productModel = new ProductModel();
        System.out.println("Enter product name: ");
        productModel.setName(scanner.next());
        System.out.println("Enter product price: ");
        productModel.setPrice(new BigDecimal(scanner.nextInt()));
        System.out.println("Enter product quantity: ");
        productModel.setQuantity(scanner.nextInt());
        productService.addProduct(productModel);
    }

    public void removeProduct(){
        System.out.println("Enter ID: ");
        productService.removeProduct(scanner.next());
    }
}
