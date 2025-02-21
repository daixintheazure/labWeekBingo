package com.Bingo.Bingo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Objects;

@Entity
public class BingoCardGen {
    @Id
    @GeneratedValue
    private int id;

    private ArrayList<BingoOption> bingoCardOptions = new ArrayList<>();

    public BingoCardGen(ArrayList<BingoOption> bingoCardOptions) {
        this.bingoCardOptions = bingoCardOptions;
    }

    public ArrayList<String> randomized() {
        ArrayList<BingoOption> tempList = this.bingoCardOptions;
        ArrayList<String> randomizedList = new ArrayList<String>();
        for(int i =0; i < 24;) {
            int random = (int) (Math.random() * tempList.size());
            if(!randomizedList.contains(tempList.get(random).toString())){
                randomizedList.add(tempList.get(random).toString());
                i++;
            }

        }
        return randomizedList;
    }

    public ArrayList<ArrayList<String>> bingoCards() {
        ArrayList<String> tempRandom = this.randomized();

        ArrayList<ArrayList<String>> options = new ArrayList<ArrayList<String>>();

        int count = tempRandom.size();
        int row = 5;
        int counter = 0;


        for (int i = 0; i < row; i++) {
            if (counter < count) {
                ArrayList<String> rowList = new ArrayList<String>();
                options.add(rowList);;
                for (int j = 0; j < row; j++){
                    if (counter == count){
                        return options;
                    }
                    if (counter == 12) {
                        rowList.add("img:/img/labWeek.png");
                        j++;
                        rowList.add(tempRandom.get(counter));
                        counter++;
                    } else {
                        rowList.add(tempRandom.get(counter));
                        counter++;
                    }
                }
            }

        }
        return options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BingoCardGen that = (BingoCardGen) o;
        return id == that.id && Objects.equals(bingoCardOptions, that.bingoCardOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bingoCardOptions);
    }

    @Override
    public String toString() {
        return "BingoCardGen{" +
                "bingoCardOptions=" + bingoCardOptions +
                '}';
    }

    public int getId() {
        return id;
    }

    public ArrayList<ArrayList<String>> getBingoCards() {
        return this.bingoCards();
    }

}