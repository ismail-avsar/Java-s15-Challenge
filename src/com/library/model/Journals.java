package com.library.model;

public class Journals extends Book {

    private String issueNumber;
    private String publishDate;

    public Journals(int bookID, String title, Author author, double price, String issueNumber, String publishDate) {
        super(bookID, title, author, price);
        this.issueNumber = issueNumber;
        this.publishDate = publishDate;
    }

    public String getIssueNumber() { return issueNumber; }
    public String getPublishDate() { return publishDate; }

    @Override
    public void display() {
        System.out.println("[Dergi/Jurnal] ID: " + getBookID() +
                " | İsim: " + getTitle() +
                " | Yazar: " + getAuthor().getName() +
                " | Sayı: " + issueNumber +
                " | Tarih: " + publishDate +
                " | Fiyat: " + getPrice() + " TL");
    }
}