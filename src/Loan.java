public class Loan {
    private final Member member;
    private final Book book;

    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Loan [Book: " + book.getTitle() + ", Member: " + member.getName() + "]";
    }
}