import com.library.model.*;
import com.library.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Librarian librarian = new Librarian("Zeynep Hanım", "12345", library);

        Author author1 = new Author("Sabahattin Ali");
        Author author2 = new Author("George Orwell");

        Book book1 = new StudyBook(1, "Kürk Mantolu Madonna", author1, 50.0);
        Book book2 = new StudyBook(2, "1984", author2, 75.0);
        Book book3 = new StudyBook(3, "Hayvan Çiftliği", author2, 60.0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Student student1 = new Student(101, "Ali Yılmaz");
        library.addMember(student1);

        System.out.println("-------------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("=== KÜTÜPHANE YÖNETİM SİSTEMİNE HOŞ GELDİNİZ ===");

        while (isRunning) {
            System.out.println("\nLütfen yapmak istediğiniz işlemi seçin:");
            System.out.println("1 - Tüm Kitapları Listele");
            System.out.println("2 - Kitap Ödünç Al");
            System.out.println("3 - Kitap İade Et");
            System.out.println("4 - Üye Fatura (Borç) Sorgula");
            System.out.println("5 - Kitap Sil");
            System.out.println("6 - İsme Göre Kitap Ara");
            System.out.println("7 - Yazara Göre Kitap Listele");
            System.out.println("8 - Kitap Bilgilerini Güncelle");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    System.out.print("Ödünç alınacak Kitap ID: ");
                    int bId = scanner.nextInt();
                    System.out.print("İşlem yapacak Üye ID: ");
                    int mId = scanner.nextInt();
                    librarian.issueBook(bId, mId);
                    break;
                case 3:
                    System.out.print("İade edilecek Kitap ID: ");
                    int retBId = scanner.nextInt();
                    System.out.print("İşlem yapacak Üye ID: ");
                    int retMId = scanner.nextInt();
                    librarian.returnBook(retBId, retMId);
                    break;
                case 4:
                    System.out.print("Sorgulanacak Üye ID giriniz: ");
                    int studentId = scanner.nextInt();
                    MemberRecord member = library.getMemberById(studentId);
                    if(member != null) {
                        System.out.println("-> " + member.getName() + " adlı üyenin güncel borcu: " + member.getBill() + " TL");
                    } else {
                        System.out.println("Hata: Sistemde böyle bir üye bulunamadı.");
                    }
                    break;
                case 5:
                    System.out.print("Silinecek Kitabın ID'sini girin: ");
                    int delId = scanner.nextInt();
                    library.removeBook(delId);
                    break;
                case 6:
                    System.out.print("Aramak istediğiniz kitabın adını girin: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBookByTitle(searchTitle);
                    break;
                case 7:
                    System.out.print("Kitaplarını görmek istediğiniz yazarın adını girin (Örn: Sabahattin Ali): ");
                    String searchAuthor = scanner.nextLine();
                    library.listBooksByAuthor(searchAuthor);
                    break;
                case 8:
                    System.out.print("Güncellenecek Kitap ID: ");
                    int upId = scanner.nextInt();
                    scanner.nextLine(); // Satır atlama düzeltmesi
                    System.out.print("Yeni Kitap İsmi: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Yeni Fiyat: ");
                    double newPrice = scanner.nextDouble();
                    library.updateBook(upId, newTitle, newPrice);
                    break;
                case 0:
                    System.out.println("Sistemden çıkılıyor. İyi günler dileriz!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim, lütfen tekrar deneyin.");
            }
        }

        scanner.close();
    }
}