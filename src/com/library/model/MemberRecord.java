package com.library.model;
import java.util.ArrayList;
import java.util.List;

public abstract class MemberRecord {
    private int memberId;
    private String name;
    private int maxBookLimit;
    private double bill;

    private List<Book> borrowedBooks;

    public MemberRecord(int memberId, String name, int maxBookLimit) {
        this.memberId = memberId;
        this.name = name;
        this.maxBookLimit = maxBookLimit;
        this.bill = 0.0;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public double getBill() { return bill; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void addBill(double amount) { this.bill += amount; }
    public void refundBill(double amount) { this.bill -= amount; }

    public boolean canBorrow() {
        return borrowedBooks.size() < maxBookLimit;
    }
}