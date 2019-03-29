package model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String book_name;

    @NonNull
    private String type;

    private int progress;
}
