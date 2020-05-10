package com.exceptions;

import org.w3c.dom.ls.LSOutput;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(){
        super("Category not found!");
    }
}
