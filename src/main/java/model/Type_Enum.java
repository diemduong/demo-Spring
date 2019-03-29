package model;

public enum Type_Enum {

    Horror("Horror"),
    ScienceFiction("Science Fiction"),
    Fantasy("Fantasy"),
    Thriller("Thriller"),
    Comedy("Comedy"),
    Roman("Roman");

    private final String description;

    Type_Enum(String info) {
        description = info;
    }

    public String getDescription() {
        return description;
    }
}
