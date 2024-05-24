package com.Bingo.Bingo.data;

import com.Bingo.Bingo.models.ListPair;

import java.util.ArrayList;
import java.util.Objects;

public final class ListData {

    private ArrayList<ListPair> array = new ArrayList<>();

    private void exampleList() {
        ListPair selections = new ListPair("Selection");

        //ArrayList<String> selection = new ArrayList<String>();
        selections.listPairAdd("CLOTTED CBC");
        selections.listPairAdd("CALLED SERVICE");
        selections.listPairAdd("TUBE STATION GOES DOWN");
        selections.listPairAdd("HEMOLYZED SPECIMEN");
        selections.listPairAdd("WAXED ALCOHOL PAD (FIND IT)");
        selections.listPairAdd("ED CALLS FOR MISSING SPECIMEN");
        selections.listPairAdd("CALLED A CRITICAL");
        selections.listPairAdd("LEVEL 1/MTP");
        selections.listPairAdd("TECH DOES THE TEG DANCE");
        selections.listPairAdd("SOMEONE NEEDS GLUCOSE STRIPS");
        selections.listPairAdd("ANTIBODY");
        selections.listPairAdd("TALKED TO SALTY NURSE");
        selections.listPairAdd("SOMEONE CALLS FOR A PHLEBOTOMIST");
        selections.listPairAdd("COAG TUBE NOT FILLED PROPERLY");
        selections.listPairAdd("URINE SPILLS IN THE BAG");
        selections.listPairAdd("TAKE DOWN CHEMISTRY INSTRUMENTS DUE TO YUCKY PROBES");
        selections.listPairAdd("SLIDE STAINER BREAKS");
        selections.listPairAdd("SOMEONE CALLS FOR COVID SWABS");
        selections.listPairAdd("QC DOES NOT PASS THE FIRST TIME");
        selections.listPairAdd("MISLABLED SAMPLE");
        selections.listPairAdd("LAB FLOOD");
        selections.listPairAdd("VISION ABORTS A CARD");
        selections.listPairAdd("BROKEN GLUCOMETER");
        selections.listPairAdd("ELAINE TAKES OUT THE TRASH");



        array.add(selections);
    }

    public ListData() {
        this.array= array;
        exampleList();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListData listData = (ListData) o;
        return Objects.equals(array, listData.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    @Override
    public String toString() {
        return array.toString();
    }

    public ListPair getArray(int index) {
        return array.get(index);
    }

    public ArrayList<ListPair> getList() {
        return array;
    }
}
