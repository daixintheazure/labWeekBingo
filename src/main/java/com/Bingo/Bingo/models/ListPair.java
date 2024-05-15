package com.Bingo.Bingo.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.aot.generate.Generated;

import java.util.ArrayList;
public class ListPair {

    private int id;
    private static int nextID = 0;
    private String name;
    private ArrayList<String> array = new ArrayList<>();

    public ListPair(String name, ArrayList<String> array) {
        id = nextID++;
        this.name = name;
        this.array = array;
    }


}
