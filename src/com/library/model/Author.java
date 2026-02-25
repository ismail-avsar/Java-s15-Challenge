package com.library.model;


public class Author extends Person {

    public Author(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir Yazarım. İsmim: " + getName());
    }
}