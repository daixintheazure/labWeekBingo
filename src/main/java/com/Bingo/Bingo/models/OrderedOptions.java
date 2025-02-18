package com.Bingo.Bingo.models;

import java.util.ArrayList;
import java.util.Objects;

public class OrderedOptions {
    private ArrayList<String> array = new ArrayList<>();
    public OrderedOptions (ArrayList<String> array) {
        this.array = array;
    }

    public ArrayList<String> randomized() {
        ArrayList<String> tempList = this.array;
        ArrayList<String> randomizedList = new ArrayList<>();
        for(int i =0; i < 24;) {
            int random = (int) (Math.random() * tempList.size());
            if(!randomizedList.contains(tempList.get(random))){
                randomizedList.add(tempList.get(random));
                i++;
            }

        }
        return randomizedList;
    }

    public ArrayList<ArrayList<String>> bingoCard() {
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
    public String toString() {
        return array.toString();
    }

    //hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedOptions that = (OrderedOptions) o;
        return Objects.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    //Getters and setters
    public ArrayList<String> getArray() {
        return array;
    }

    public ArrayList<ArrayList<String>> getBingoSet(){
        ArrayList<ArrayList<String>> bingoCard = this.bingoCard();
        return bingoCard;
    }

    public void setArray(ArrayList<String> array) {
        this.array = array;
    }
}
