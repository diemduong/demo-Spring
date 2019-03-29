package model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String book_name;

    @Column(name = "Type")
    @NonNull
    private String type;

    @Column(name = "progress")
    private int progress;

    public Book(String book_name, String type, int progress) {
        this.book_name = book_name;
        this.type = type;
        this.progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String toString() {
        return "Book " + id + ": " + book_name + " with type " + type + " at " + progress + "%";
    }
}
