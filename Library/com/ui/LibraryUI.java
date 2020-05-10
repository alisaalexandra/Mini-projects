package com.ui;

import java.util.Scanner;

public class LibraryUI {

    private AuthorUI authorUI = new AuthorUI();
    private BookUI bookUI = new BookUI();
    private ReviewUI reviewUI = new ReviewUI();

    public void startLibraryUI() {
        Scanner scanner = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            System.out.println("Book management system");
            System.out.println("1.Authors");
            System.out.println("2.Books");
            System.out.println("3.Reviews");
            System.out.println("0.Exit");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                authorUI.startAuthorUI();
            } else if (option == 2) {
                bookUI.startBookUI();
            } else if (option == 3) {
                reviewUI.startReviewUI();
            }
        }
    }
}
