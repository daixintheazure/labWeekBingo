package com.Bingo.Bingo.models;

import com.Bingo.Bingo.models.BingoOptionsList;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class BingoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "bingo_options_list_id")
    @JsonBackReference
    private BingoOptionsList bingoOptionsList;

    @Lob
    @Column(columnDefinition = "TEXT") // Store JSON as TEXT
    private String bingoCardJson;

    @Transient // Don't persist this directly
    private ArrayList<ArrayList<String>> bingoCard = new ArrayList<>();

    public BingoCard() {}

    public BingoCard(ArrayList<ArrayList<String>> bingoCard) {
        this.bingoCard = bingoCard;
        this.bingoCardJson = convertToJson(bingoCard);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BingoOptionsList getBingoOptionsList() {
        return bingoOptionsList;
    }

    public void setBingoOptionsList(BingoOptionsList bingoOptionsList) {
        this.bingoOptionsList = bingoOptionsList;
    }

    public ArrayList<ArrayList<String>> getBingoCard() {
        return convertFromJson(this.bingoCardJson);
    }

    public void setBingoCard(ArrayList<ArrayList<String>> bingoCard) {
        this.bingoCard = bingoCard;
        this.bingoCardJson = convertToJson(bingoCard);
    }

    private String convertToJson(ArrayList<ArrayList<String>> data) {
        try {
            return new ObjectMapper().writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    private ArrayList<ArrayList<String>> convertFromJson(String json) {
        try {
            return new ObjectMapper().readValue(json, ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return bingoCardJson;
    }
}

