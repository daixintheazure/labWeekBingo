package com.Bingo.Bingo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BingoOption {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotBlank
    private String bingoOption;

    @ManyToMany
    @JoinColumn(name = "bingoOptionsList_id")
    private List<BingoOptionsList> bingoOptionsList = new ArrayList<>();

    public BingoOption() {}

    public BingoOption(String option) {
        this.bingoOption = option;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BingoOption that = (BingoOption) o;
        return id == that.id && Objects.equals(bingoOption, that.bingoOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bingoOption);
    }

    @Override
    public String toString() {
        return bingoOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBingoOption() {
        return bingoOption;
    }

    public void setBingoOption(String bingoOption) {
        this.bingoOption = bingoOption;
    }

    public List<BingoOptionsList> getBingoOptionsList() {
        return bingoOptionsList;
    }

    public void setBingoOptionsList(List<BingoOptionsList> bingoOptionsList) {
        this.bingoOptionsList = bingoOptionsList;
    }
}
