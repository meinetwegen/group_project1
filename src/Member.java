import java.util.ArrayList;
import java.util.List;

public class Member {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final List<Loan> currentLoans;

    public Member(String name) {
        this.id = nextId++;
        this.name = name;
        this.currentLoans = new ArrayList<>();
    }

    public void addLoan(Loan loan) {
        this.currentLoans.add(loan);
    }

    public void removeLoan(Loan loan) {
        this.currentLoans.remove(loan);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getCurrentLoans() {
        return currentLoans;
    }

    @Override
    public String toString() {
        return "Member [ID: " + id + ", Name: " + name + ", Loans: " + currentLoans.size() + "]";
    }
}