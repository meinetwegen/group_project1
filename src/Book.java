public class Book {
    private int id;
    private static int id_gen = 0;
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.id = id_gen++;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isLoaned() {
        return !available;
    }

    @Override
    public String toString() {
        return "Book [ID: " + id + ", Title: '" + title + "', Author: " + author + ", Available: " + available + "]";
    }
}