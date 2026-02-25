package com.library.service;

import com.library.model.Book;
import com.library.model.MemberRecord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {

    private Map<Integer, Book> books;

    private Set<MemberRecord> members;

    private Map<Book, MemberRecord> borrowedBooksTracker;

    public Library() {
        this.books = new HashMap<>();
        this.members = new HashSet<>();
        this.borrowedBooksTracker = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookID(), book);
        System.out.println("Kitap kütüphaneye eklendi: " + book.getTitle());
    }

    public void removeBook(int bookId) {
        if (books.containsKey(bookId)) {
            Book removedBook = books.remove(bookId);
            System.out.println("Kitap sistemden silindi: " + removedBook.getTitle());
        } else {
            System.out.println("Hata: " + bookId + " ID'li kitap bulunamadı.");
        }
    }

    public Book getBookById(int bookId) {
        return books.get(bookId);
    }

    public void displayAllBooks() {
        System.out.println("--- Kütüphanedeki Tüm Kitaplar ---");
        for (Book book : books.values()) {
            book.display();
        }
    }

    public void addMember(MemberRecord member) {
        members.add(member);
        System.out.println("Yeni üye kaydedildi: " + member.getName());
    }

    public MemberRecord getMemberById(int memberId) {
        for (MemberRecord member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public Map<Integer, Book> getBooks() { return books; }
    public Map<Book, MemberRecord> getBorrowedBooksTracker() { return borrowedBooksTracker; }
    public void searchBookByTitle(String title) {
        boolean found = false;
        System.out.println("--- Arama Sonuçları ---");
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.display();
                found = true;
            }
        }
        if (!found) System.out.println("Bu isimde bir kitap bulunamadı.");
    }

    public void listBooksByAuthor(String authorName) {
        boolean found = false;
        System.out.println("--- " + authorName + " Kitapları ---");
        for (Book book : books.values()) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                book.display();
                found = true;
            }
        }
        if (!found) System.out.println("Bu yazara ait kitap bulunamadı.");
    }

    public void updateBook(int bookId, String newTitle, double newPrice) {
        if (books.containsKey(bookId)) {
            Book book = books.get(bookId);
            book.setTitle(newTitle);
            book.setPrice(newPrice);
            System.out.println("Kitap başarıyla güncellendi!");
        } else {
            System.out.println("Hata: Güncellenecek kitap bulunamadı.");
        }
    }

}