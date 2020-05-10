package com.persistence.dao;

import com.persistence.model.AuthorModel;

import java.util.List;

public class AuthorDao extends ModelDao<AuthorModel> {
    public AuthorDao() {
        super("authors.txt");
    }

    public void removeByFirstAndLastName(String name, String lastName) {
        List<AuthorModel> authorModelList = getAll();
        authorModelList.removeIf(author -> author.getLastName().equals(lastName) &&
                author.getFirstName().equals(name));
        getFileScanner().write(authorModelList, getFileName());

    }
}
