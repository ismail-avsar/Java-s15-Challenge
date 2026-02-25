package com.library.model;

public class StudyBook extends Book {

    public StudyBook(int bookID, String title, Author author, double price) {
        super(bookID, title, author, price);
    }

    @Override
    public void display() {
        System.out.println("[Ders Kitabı] ID: " + getBookID() + " | İsim: " + getTitle() +
                " | Yazar: " + getAuthor().getName() + " | Fiyat: " + getPrice() + " TL");
    }
}