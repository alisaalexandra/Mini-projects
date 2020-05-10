package com.persistence.dao;

import com.persistence.model.BookModel;

public class BookDao extends ModelDao<BookModel> {
    public BookDao() {
        super("books.txt");
    }
}
