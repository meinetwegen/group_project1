public class Book {
    public int id;
    public static int id_gen;
    public String title;
    public boolean available;

    public Book(String title) {
        this.id = id_gen++;
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
