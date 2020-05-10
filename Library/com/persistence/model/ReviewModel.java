package com.persistence.model;

public class ReviewModel extends Model {
    private BookModel book;
    private int score;
    private String comment;

    public void setBook(BookModel book) {
        this.book = book;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BookModel getBook() {
        return book;
    }

    public String getComment() {
        return comment;
    }

    public int getScore() {
        return score;
    }
}
