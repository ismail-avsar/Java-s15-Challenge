package com.library.model;
import com.library.core.IBorrowable;

public abstract class Book implements IBorrowable {

    private int bookID;
    private String title;
    private Author author;
    private double price;
    private boolean status;

    public Book(int bookID, String title, Author author, double price) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.price = price;
        this.status = true;
    }

    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }
    public double getPrice() { return price; }

    @Override
    public void updateStatus(boolean isAvailable) {
        this.status = isAvailable;
    }

    @Override
    public boolean isAvailable() {
        return this.status;
    }

    public abstract void display();
    public void setTitle(String title) { this.title = title; }
    public void setPrice(double price) { this.price = price; }
}