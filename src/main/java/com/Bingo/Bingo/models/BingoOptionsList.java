package com.Bingo.Bingo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BingoOptionsList {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "bingoOptionsList", cascade = CascadeType.ALL)
    List<BingoOption> bingoOptionsList = new ArrayList<>();


    public BingoOptionsList() {}

    public BingoOptionsList(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BingoOptionsList bingoOptionsList = (BingoOptionsList) o;
        return id == bingoOptionsList.id && Objects.equals(name, bingoOptionsList.name);
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

    public List<BingoOption> getBingoOptionsList() {
        return bingoOptionsList;
    }

    public void setBingoOptionsList(List<BingoOption> bingoOptionsList) {
        this.bingoOptionsList = bingoOptionsList;
    }
}
