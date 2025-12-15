//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Library centralLibrary = new Library("Library");

        //String title1 = scanner.nextLine(); // i td
        Book book1 = new Book("The Lord of the Rings", "Tolkien");
        Book book2 = new Book("Crime and Punishment", "Lev Tolstoy");
        Book book3 = new Book("1984", "George Orwell");

        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);
        centralLibrary.addBook(book3);

        Member alex = new Member("Alexandra Koziy");
        Member batyr = new Member("Ashenov Batyrkhan");

        centralLibrary.addMember(alex);
        centralLibrary.addMember(batyr);

        System.out.println(book1);
        System.out.println(alex);
        System.out.println(batyr);

        centralLibrary.issueBook(alex, book1);
        System.out.println("Status:");
        System.out.println(book1);
        System.out.println(alex);

        System.out.println("\nDublicate loan");
        centralLibrary.issueBook(batyr, book1);

        centralLibrary.issueBook(batyr, book2);

        centralLibrary.returnBook(alex, book1);

        centralLibrary.issueBook(batyr, book1);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(alex);
        System.out.println(batyr);
        System.out.println("Active loans: " + centralLibrary.getActiveLoans().size());

        System.out.println("\nIncorrect return");
        centralLibrary.returnBook(batyr, book3);
    }
}