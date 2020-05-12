package com.ui;

import com.persistence.model.BookModel;
import com.persistence.model.ReviewModel;
import com.services.BookService;
import com.services.ReviewService;

import java.util.List;
import java.util.Scanner;

public class ReviewUI {
    private ReviewService reviewService = new ReviewService();
    private BookService bookService = new BookService();
    private Scanner scanner = new Scanner(System.in);

    public void startReviewUI() {
        int option = -1;
        while (option != 0) {
            System.out.println("Review management");
            System.out.println("1.View reviews");
            System.out.println("2.Add review");
            System.out.println("0.Back");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                viewReviews();
            } else if (option == 2) {
                addReview();
            }
        }
    }

    public void viewReviews() {
        List<BookModel> bookModels = bookService.getBooks();
        bookModels.stream().forEach(parameter -> System.out.println("Author - " + parameter.getAuthor().getLastName() +
                "\nBOOK: " + parameter.getTitle() +
                "\nScore - " + parameter.getReview().getScore() + "\nComments - " + parameter.getReview().getComment()));
    }

    public void addReview() {
        viewBooks();
        System.out.println("Enter book's title: ");
        BookModel book = bookService.getBook(scanner.next()).get();
        ReviewModel review = new ReviewModel();
        System.out.println("How would you rate this book? 1 - 5 ");
        review.setBook(book);
        review.setScore(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Any thoughts about this book? Let us know.");
        review.setComment(scanner.nextLine());
        book.setReview(review);

        reviewService.addReview(book, review);
    }

    public void viewBooks() {
        System.out.println("Books");
        List<BookModel> bookModelList = bookService.getBooks();
        bookModelList.stream().forEach(bookModel ->
                System.out.println(bookModel.getTitle() +
                        " - " + bookModel.getAuthor().getFirstName() +
                        " " + bookModel.getAuthor().getLastName()));
    }
}
