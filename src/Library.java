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

    public void issueBook(Member member, Book book){
        if(members.contains(member)){
            if(books.contains(book)){
                if(book.isAvailable()){
                    book.setAvailable(false);
                    members.addLoan(member, book);
                }
            }
        }
    }

   public void returnBook(Member member, Book book){

   }


    public List<Book> getBooks() {
        return books;
    }

    public List<Loan> getActiveLoans() {
        return activeLoans;
    }
}