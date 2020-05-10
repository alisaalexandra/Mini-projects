package com.ui;

import com.persistence.model.AuthorModel;
import com.services.AuthorService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AuthorUI {

    private AuthorService authorService = new AuthorService();
    Scanner scanner = new Scanner(System.in);

    public void startAuthorUI() {

        int option = -1;

        while (option != 0) {
            System.out.println("Authors management");
            System.out.println("1.View authors");
            System.out.println("2.Add new author");
            System.out.println("3.Delete author");
            System.out.println("4.Update author");
            System.out.println("0.Back");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                viewAuthorList();
            } else if (option == 2) {
                addAuthor();
            } else if (option == 3) {
                deleteAuthor();
            } else if (option == 4) {
                updateAuthor();
            }
        }
    }

    public void viewAuthorList() {
        List<AuthorModel> authorModelList = authorService.getAllAuthors();
        authorModelList.stream().forEach(author ->
                System.out.println(author.getLastName()
                        + " " + author.getFirstName()));
    }

    public void addAuthor() {
        System.out.println("Enter first name of the author");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the author");
        String lastName = scanner.nextLine();
        AuthorModel authorModel = new AuthorModel(firstName, lastName);
        authorService.addAuthor(authorModel);
    }


    public void deleteAuthor() {
        System.out.println("Enter fist name of the author");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the author");
        String lastName = scanner.nextLine();
        authorService.deleteAuthor(firstName, lastName);
    }

    public void updateAuthor() {
        System.out.println("Enter fist name of the author");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the author");
        String lastName = scanner.nextLine();
        Optional<AuthorModel> authorModelBox = authorService.findByName(firstName, lastName);
        if (!authorModelBox.isPresent()) {
            System.out.println("Author was not found");

        } else {
            AuthorModel authorModel = authorModelBox.get();
            System.out.println("What do you want to change?");
            System.out.println("1. First name");
            System.out.println("2. Last name name");

            int changeNameOption = scanner.nextInt();
            scanner.nextLine();
            if (changeNameOption == 1) {
                System.out.println("Enter new first name");
                String newName = scanner.nextLine();
                authorModel.setFirstName(newName);
            } else if (changeNameOption == 2) {
                System.out.println("Enter new lastName name");
                String newLastName = scanner.nextLine();
                authorModel.setLastName(newLastName);
            }
            authorService.update(authorModel);
        }
    }
}
