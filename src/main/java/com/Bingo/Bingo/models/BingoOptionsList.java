package com.Bingo.Bingo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BingoOptionsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank(message = "Name may not be blank")
    private String name;

    @ManyToMany
    @JoinTable(name = "bingo_options_mapping", joinColumns = @JoinColumn(name = "bingo_id"),
    inverseJoinColumns = @JoinColumn(name = "option_id"))
    private List<BingoOption> bingoOptionsList = new ArrayList<>();

    @OneToMany (mappedBy = "bingoOptionsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BingoCard> bingoCards;


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

    public List<BingoCard> getBingoCards() {
        return bingoCards;
    }

    public void setBingoCards(List<BingoCard> bingoCards) {
        this.bingoCards = bingoCards;
    }
}
