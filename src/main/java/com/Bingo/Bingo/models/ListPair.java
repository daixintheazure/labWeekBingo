package com.Bingo.Bingo.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.aot.generate.Generated;

import java.util.ArrayList;
import java.util.Objects;

public class ListPair {

    private int id;
    private static int nextID = 0;
    private String name;
    private ArrayList<String> array = new ArrayList<>();

    public ListPair(String name) {
        id = nextID++;
        this.name = name;
        //this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPair listPair = (ListPair) o;
        return id == listPair.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public ArrayList<String> getArray() {
        return array;
    }

    public void setArray(ArrayList<String> array) {
        this.array = array;
    }

    public void listPairAdd(String string) {
        array.add(string);
    }

    public void listPairRemove (int index) {
        array.remove(index);
    }
}
