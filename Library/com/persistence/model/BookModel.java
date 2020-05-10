package com.persistence.model;

public class BookModel extends Model {

    private String title;
    private String description;
    private AuthorModel author;
    private ReviewModel review;

    public BookModel(String title, AuthorModel authorModel) {
        this.title = title;
        this.author = authorModel;
    }

    public void setDescriere(String descriere) {
        this.description = descriere;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public String getDescriere() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

    public ReviewModel getReview() {
        return review;
    }
}
