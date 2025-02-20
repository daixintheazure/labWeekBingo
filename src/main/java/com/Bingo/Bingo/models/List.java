package com.Bingo.Bingo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class List {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    ArrayList<BingoOption> bingoOptionList = new ArrayList<>();

    public List () {}

    public List(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return id == list.id && Objects.equals(name, list.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<BingoOption> getBingoOptionList() {
        return bingoOptionList;
    }

}
