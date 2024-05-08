package com.Bingo.Bingo.data;

import java.util.ArrayList;
import java.util.Objects;

public final class ListData {

    private ArrayList<ArrayList> array = new ArrayList<>();

    private void exampleList() {
        ArrayList<String> selection = new ArrayList<String>();
        selection.add("CLOTTED CBC");
        selection.add("CALLED SERVICE");
        selection.add("TUBE STATION GOES DOWN");
        selection.add("HEMOLYZED SPECIMEN");
        selection.add("WAXED ALCOHOL PAD (FIND IT)");
        selection.add("ED CALLS FOR MISSING SPECIMEN");
        selection.add("CALLED A CRITICAL");
        selection.add("LEVEL 1/MTP");
        selection.add("TECH DOES THE TEG DANCE");
        selection.add("SOMEONE NEEDS GLUCOSE STRIPS");
        selection.add("ANTIBODY");
        selection.add("TALKED TO SALTY NURSE");
        selection.add("SOMEONE CALLS FOR A PHLEBOTOMIST");
        selection.add("COAG TUBE NOT FILLED PROPERLY");
        selection.add("URINE SPILLS IN THE BAG");
        selection.add("TAKE DOWN CHEMISTRY INSTRUMENTS DUE TO YUCKY PROBES");
        selection.add("SLIDE STAINER BREAKS");
        selection.add("SOMEONE CALLS FOR COVID SWABS");
        selection.add("QC DOES NOT PASS THE FIRST TIME");
        selection.add("MISLABLED SAMPLE");
        selection.add("LAB FLOOD");
        selection.add("VISION ABORTS A CARD");
        selection.add("BROKEN GLUCOMETER");
        selection.add("ELAINE TAKES OUT THE TRASH");

        array.add(selection);
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

    public ArrayList<String> getArray(int index) {
        return array.get(index);
    }
}
