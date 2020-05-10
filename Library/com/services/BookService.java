package com.services;

import com.persistence.dao.BookDao;
import com.persistence.model.BookModel;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService {

    private BookDao bookDao = new BookDao();

    public void addBook(BookModel book) {
        long code = System.currentTimeMillis();
        book.setCode(code);
        bookDao.add(book);
    }

    public List<BookModel> getBooks() {
        return bookDao.getAll().stream()
                .sorted(Comparator.comparing(
                        book -> book.getTitle()))
                .collect(Collectors.toList());
    }


    public void removeBook(String name) {
        List<BookModel> bookModels = bookDao.getAll();
        for (int i = 0; i < bookModels.size(); i++) {
            BookModel bookModel = bookModels.get(i);
            if (bookModel.getTitle().equals(name)) {
                bookDao.remove(bookModel.getCode());
            }
        }

    }

    public Optional<BookModel> getBook(String title) {
        return bookDao.getAll().stream()
                .filter(bookModel ->
                        bookModel.getTitle().equals(title))
                .findFirst();
    }

    public void updateBook(BookModel bookFound) {
        bookDao.remove(bookFound.getCode());
        bookDao.add(bookFound);
    }
}
