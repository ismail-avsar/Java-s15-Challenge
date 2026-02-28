package com.library.model;

public class Magazines extends Book {

    private String category;
    private String monthlyEdition;

    public Magazines(int bookID, String title, Author author, double price, String category, String monthlyEdition) {
        super(bookID, title, author, price);
        this.category = category;
        this.monthlyEdition = monthlyEdition;
    }

    public String getCategory() { return category; }
    public String getMonthlyEdition() { return monthlyEdition; }

    @Override
    public void display() {
        System.out.println("[Magazin] ID: " + getBookID() +
                " | İsim: " + getTitle() +
                " | Yazar: " + getAuthor().getName() +
                " | Kategori: " + category +
                " | Baskı: " + monthlyEdition +
                " | Fiyat: " + getPrice() + " TL");
    }
}