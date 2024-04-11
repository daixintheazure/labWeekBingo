package com.Bingo.Bingo.controllers;

import com.Bingo.Bingo.models.OrderedOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CardController {


    @GetMapping("/")
    public String bingoCards(Model model) {
        final ArrayList<String> selection = new ArrayList<String>();
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

        OrderedOptions bingo = new OrderedOptions(selection);

        model.addAttribute("bingo", bingo.getBingoSet());


        return "index";
    }

}
