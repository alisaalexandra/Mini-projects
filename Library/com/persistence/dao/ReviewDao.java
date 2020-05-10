package com.persistence.dao;

import com.persistence.model.ReviewModel;

public class ReviewDao extends ModelDao<ReviewModel> {
    public ReviewDao() {
        super("reviews.txt");
    }
}
