import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final List<Book> books;
    private final List<Member> members;
    private final List<Loan> activeLoans;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.activeLoans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Added member: " + member.getName());
    }

    private Book findBook(Book bookToFind) {
        for (Book b : books) {
            if (b.getId() == bookToFind.getId()) {
                return b;
            }
        }
        return null;
    }

    private Loan findActiveLoan(Member member, Book book) {
        for (Loan loan : activeLoans) {
            if (loan.getBook().getId() == book.getId() && loan.getMember().getId() == member.getId()) {
                return loan;
            }
        }
        return null;
    }

    public boolean issueBook(Member member, Book book) {

        Book actualBook = findBook(book);

        if (actualBook == null) {
            System.out.println("Book not found");
            return false;
        }

        if (actualBook.isLoaned()) {
            System.out.println("Book '" + actualBook.getTitle() + "' is on loan.");
            return false;
        }

        actualBook.setAvailable(false);

        Loan newLoan = new Loan(member, actualBook);

        activeLoans.add(newLoan);
        member.addLoan(newLoan);

        System.out.println("Book '" + actualBook.getTitle() + "' issued to " + member.getName());
        return true;
    }

    public boolean returnBook(Member member, Book book) {
        Book actualBook = findBook(book);

        if (actualBook == null) {
            System.out.println("Book not found");
            return false;
        }

        Loan loanToRemove = findActiveLoan(member, actualBook);

        if (loanToRemove == null) {
            System.out.println("No active loan");
            return false;
        }

        actualBook.setAvailable(true);

        activeLoans.remove(loanToRemove);
        member.removeLoan(loanToRemove);

        System.out.println("Book '" + actualBook.getTitle() + "' returned by " + member.getName());
        return true;
    }

    public List<Book> getBooks() { return books; }
    public List<Loan> getActiveLoans() { return activeLoans; }
}