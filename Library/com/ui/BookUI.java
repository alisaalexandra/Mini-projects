package com.ui;

import com.persistence.model.AuthorModel;
import com.persistence.model.BookModel;
import com.persistence.model.ReviewModel;
import com.services.AuthorService;
import com.services.BookService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookUI {

    private BookService bookService = new BookService();
    private AuthorService authorService = new AuthorService();
    Scanner scanner = new Scanner(System.in);


    public void startBookUI() {
        int optiune = -1;
        while (optiune != 0) {
            System.out.println("Book Management");
            System.out.println("1.View books");
            System.out.println("2.Add books");
            System.out.println("3.Remove books");
            System.out.println("4.Update book");
            System.out.println("0.Back");
            optiune = scanner.nextInt();
            scanner.nextLine();
            if (optiune == 1) {
                viewBooks();

            } else if (optiune == 2) {
                addBook();
            } else if (optiune == 3) {
                removeBook();
            } else if (optiune == 4) {
                updateBook();

            }
        }
    }

    public void viewBooks() {
        System.out.println("Books");
        System.out.println("-----------------------------");
        List<BookModel> bookModelList = bookService.getBooks();
        bookModelList.stream().forEach(bookModel ->
                System.out.println(bookModel.getTitle() +
                        " By " + bookModel.getAuthor().getFirstName() +
                        " " + bookModel.getAuthor().getLastName()));
        System.out.println("-----------------------------");
    }

    public void addBook() {
        System.out.println("Add book");
        System.out.println("Enter book title");
        String title = scanner.nextLine();
        System.out.println("Enter book description");
        String descriere = scanner.nextLine();

        System.out.println("Enter author first name");
        String firstName = scanner.nextLine();

        System.out.println("Enter author last name");
        String lastName = scanner.nextLine();
        System.out.println("Do you want to rate this book? Y/N");
        String option = scanner.next();
        if (option.equalsIgnoreCase("Y")) {
            System.out.println("How would you rate it? 1 - 5 ");
            ReviewModel review = new ReviewModel();
            review.setScore(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Any thoughts about this book? ");
            review.setComment(scanner.nextLine());
        } else if (option.equalsIgnoreCase("N")) {
            System.out.println("No problem.");
        }

        Optional<AuthorModel> authorModelOptional = authorService.findByName(firstName, lastName);
        if (!authorModelOptional.isPresent()) {
            System.out.println("Author is not registered.Please register the author first.");
        } else {
            AuthorModel authorModel = authorModelOptional.get();
            BookModel bookModel = new BookModel(title, authorModel);
            bookModel.setDescriere(descriere);
            bookService.addBook(bookModel);
        }
    }

    public void removeBook() {
        System.out.println("Remove book");
        System.out.println("Title of book that will be removed:");
        String title = scanner.nextLine();
        bookService.removeBook(title);
    }

    public void updateBook() {
        System.out.println("Update book");
        System.out.println("Title of book that will be updated:");
        String title = scanner.nextLine();
        Optional<BookModel> bookModelOptional = bookService.getBook(title);
        if (!bookModelOptional.isPresent()) {
            System.out.println(title + " doesn't exist!");
        } else {
            BookModel bookFound = bookModelOptional.get();
            System.out.println("What do you want to update?");
            System.out.println("1.Title");
            System.out.println("2.Description");
            System.out.println("3.Author");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("New book title");
                String newTitle = scanner.nextLine();
                bookFound.setTitle(newTitle);
            }
            if (option == 2) {
                System.out.println("New book description");
                String newDescription = scanner.nextLine();
                bookFound.setDescriere(newDescription);
            }
            if (option == 3) {
                System.out.println("New book author first name:");
                String newAuthorName = scanner.nextLine();
                System.out.println("New book author last name:");
                String newAuthorLastName = scanner.nextLine();
                Optional<AuthorModel> authorModelOptional =
                        authorService.findByName(newAuthorName, newAuthorLastName);
                if (!authorModelOptional.isPresent()) {
                    System.out.println("Author is not registered.Please register the author first.");
                } else {
                    AuthorModel authorModel = authorModelOptional.get();
                    bookFound.setAuthor(authorModel);
                }
            }
            bookService.updateBook(bookFound);
        }
    }
}
