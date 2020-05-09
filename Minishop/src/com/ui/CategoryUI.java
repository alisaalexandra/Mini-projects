package com.ui;

import com.persistence.model.CategoryModel;
import com.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class CategoryUI {
    private CategoryService categoryService = new CategoryService();
    private Scanner scanner = new Scanner(System.in);

    public void startCategoryManagement() {
        int op = -1;
        while (op!=7) {
            System.out.println("1.View categories" +
                    "\n2.Find categories by id" +
                    "\n3.View ordered categories" +
                    "\n4.Update existing category" +
                    "\n5.Add new category" +
                    "\n6.Remove category" +
                    "\n7.Exit");
            op=scanner.nextInt();
            scanner.nextLine();
            if(op==1){
                getAllCategories();
            }else if(op==2){
                findCategoriesByID();
            }else if(op==3){
                getSortedList();
            }else if(op==4){
                updateCategory();
            }else if(op==5){
                addCategory();
            }else if(op==6) {
               removeCategory();
            }
        }
    }

    public void getAllCategories(){
        List<CategoryModel> categoryModels = categoryService.getAllCategories();
        categoryModels.stream().forEach(parameter -> System.out.println(parameter.getId() + " - > " + parameter.getName()));
    }
    public void findCategoriesByID(){
        System.out.println("Enter id: ");
        Optional<CategoryModel> category = categoryService.getCategoryById(scanner.next());
        System.out.println(category.get().getName() + " " + category.get().getId());
    }

    public void getSortedList() {
        List<CategoryModel> sortedList =categoryService.getCategoriesOrderByName();
        sortedList.stream().forEach(parameter -> System.out.println(parameter.getId() + " " + parameter.getName()));
    }

    public void updateCategory(){
        getAllCategories();
        CategoryModel categoryModel = new CategoryModel();
        System.out.println("Enter ID: ");
        categoryModel.setId(scanner.next());
        System.out.println("Enter category new name: ");
        categoryModel.setName(scanner.next());
        categoryService.updateCategory(categoryModel);
    }

    public void addCategory(){
        CategoryModel categoryModel = new CategoryModel();
        System.out.println("Enter category name: ");
        categoryModel.setName(scanner.next());
        categoryService.addCategory(categoryModel);
    }

    public void removeCategory(){
        getAllCategories();
        System.out.println("Enter id: ");
        categoryService.removeCategory(scanner.next());
    }
}
