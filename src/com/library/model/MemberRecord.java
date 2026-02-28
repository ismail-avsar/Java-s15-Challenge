package com.library.model;
import java.util.ArrayList;
import java.util.List;

public abstract class MemberRecord extends Person {

    private int memberId;
    private int maxBookLimit;
    private double bill;
    private List<Book> borrowedBooks;

    public MemberRecord(int memberId, String name, int maxBookLimit) {
        super(name);
        this.memberId = memberId;
        this.maxBookLimit = maxBookLimit;
        this.bill = 0.0;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() { return memberId; }
    public double getBill() { return bill; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void addBill(double amount) { this.bill += amount; }
    public void refundBill(double amount) { this.bill -= amount; }

    public boolean canBorrow() {
        return borrowedBooks.size() < maxBookLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberRecord)) return false;
        MemberRecord that = (MemberRecord) o;
        return memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(memberId);
    }
}