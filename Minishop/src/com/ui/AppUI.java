package com.ui;

import java.util.Scanner;

public class AppUI {
    private Scanner scanner = new Scanner(System.in);
    private CategoryUI categoryUI = new CategoryUI();
    private ProductUI productUI = new ProductUI();

    public void startApp() {
        int option = -1;
        while (option != 0) {
            System.out.println("---Small Shop Management---");
            System.out.println("1.Category Management" +
                    "\n2.Product Management" +
                    "\n0.Exit");
            option=scanner.nextInt();
            scanner.nextLine();
            if(option==1){
                categoryUI.startCategoryManagement();
            }else if(option==2){
                productUI.startProductManagement();
            }
        }
    }
}
