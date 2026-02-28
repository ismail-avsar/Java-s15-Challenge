package com.library.model;

public class StudyBook extends Book {

    private String edition;
    private String subject;

    public StudyBook(int bookID, String title, Author author, double price, String edition, String subject) {
        super(bookID, title, author, price);
        this.edition = edition;
        this.subject = subject;
    }

    public StudyBook(int bookID, String title, Author author, double price) {
        super(bookID, title, author, price);
        this.edition = "1. Baskı";
        this.subject = "Genel";
    }

    public String getEdition() { return edition; }
    public String getSubject() { return subject; }

    @Override
    public void display() {
        System.out.println("[Ders Kitabı] ID: " + getBookID() +
                " | İsim: " + getTitle() +
                " | Yazar: " + getAuthor().getName() +
                " | Konu: " + subject +
                " | Baskı: " + edition +
                " | Fiyat: " + getPrice() + " TL");
    }
}