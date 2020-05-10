package com.services;

import com.persistence.dao.AuthorDao;
import com.persistence.model.AuthorModel;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorService {

    private AuthorDao authorDao = new AuthorDao();

    public void addAuthor(AuthorModel authorModel) {
        authorDao.add(authorModel);
    }

    public void deleteAuthor(String firstName, String lastname) {
        authorDao.removeByFirstAndLastName(firstName, lastname);
    }

    public void update(AuthorModel authorModel) {
        authorDao.removeByFirstAndLastName(authorModel.getFirstName(),
                authorModel.getLastName());
        authorDao.add(authorModel);
    }


    public List<AuthorModel> getAllAuthors() {
        return authorDao.getAll().stream()
                .sorted(Comparator.comparing(author -> author.getLastName()))
                .collect(Collectors.toList());
    }

    public Optional<AuthorModel> findByName(String firstName, String lastName) {
        List<AuthorModel> authorModelList = authorDao.getAll();
        return authorModelList.stream().filter(authorModel ->
                authorModel.getFirstName().equals(firstName)
                        && authorModel.getLastName().equals(lastName)).findFirst();
    }
}
