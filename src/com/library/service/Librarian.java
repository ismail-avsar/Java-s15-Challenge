package com.library.service;
import com.library.model.Book;
import com.library.model.MemberRecord;

public class Librarian {
    private String name;
    private String password;
    private Library library;

    public Librarian(String name, String password, Library library) {
        this.name = name;
        this.password = password;
        this.library = library;
    }

    public void issueBook(int bookId, int memberId) {
        Book book = library.getBookById(bookId);
        MemberRecord member = library.getMemberById(memberId);

        if (book == null) {
            System.out.println("Hata: Kitap bulunamadı.");
            return;
        }
        if (member == null) {
            System.out.println("Hata: Üye bulunamadı.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Üzgünüz, bu kitap şu an başkasında.");
            return;
        }

        if (!member.canBorrow()) {
            System.out.println("Limit aşıldı! En fazla " + member.getBorrowedBooks().size() + " kitap alabilirsiniz.");
            return;
        }

        book.updateStatus(false);
        member.getBorrowedBooks().add(book);
        member.addBill(book.getPrice());
        library.getBorrowedBooksTracker().put(book, member);

        System.out.println("Başarılı: '" + book.getTitle() + "' kitabı " + member.getName() + " kullanıcısına ödünç verildi.");
        System.out.println("Güncel Fatura: " + member.getBill() + " TL");
    }

    public void returnBook(int bookId, int memberId) {
        Book book = library.getBookById(bookId);
        MemberRecord member = library.getMemberById(memberId);

        if (book != null && member != null) {
            if (library.getBorrowedBooksTracker().get(book) == member) {

                book.updateStatus(true);
                member.getBorrowedBooks().remove(book);
                member.refundBill(book.getPrice());
                library.getBorrowedBooksTracker().remove(book);

                System.out.println("Başarılı: '" + book.getTitle() + "' kitabı iade edildi.");
                System.out.println("Güncel Fatura: " + member.getBill() + " TL");
            } else {
                System.out.println("Hata: Bu kitap bu kullanıcı tarafından ödünç alınmamış.");
            }
        }
    }
}