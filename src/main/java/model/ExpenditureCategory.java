package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class ExpenditureCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;


    public ExpenditureCategory() {
    }

    public ExpenditureCategory(long id) {
        this.id = id;
    }

    public ExpenditureCategory(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

}