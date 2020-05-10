package com.services;

import com.persistence.dao.ReviewDao;
import com.persistence.model.BookModel;
import com.persistence.model.ReviewModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {
    private ReviewDao reviewDao = new ReviewDao();

    public List<ReviewModel> viewReviews() {
        return reviewDao.getAll().stream().sorted(Comparator.comparing(parameter -> parameter.getBook().getReview().getScore())).collect(Collectors.toList());
    }

    public void addReview(BookModel book, ReviewModel review) {
        book.setReview(review);
        reviewDao.getAll().add(review);
    }
}
