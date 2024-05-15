package com.Bingo.Bingo.controllers;

import com.Bingo.Bingo.data.ListData;
import com.Bingo.Bingo.models.OrderedOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("bingo")
public class CardController {

    ListData listData = new ListData();

    @GetMapping("create")
    //Shows form that crates bingo Cards
    public String createBingoCards (Model model) {

        return "bingo/create";

    }


    @GetMapping("view")
    //Show list of List to select from
    public String viewCardsList(Model model) {
            model.addAttribute("listData", listData.getList());
            return "bingo/view";
    }


    @PostMapping("results")
    public String bingoCards(Model model) {

        OrderedOptions bingo1 = new OrderedOptions(listData.getArray(0));
        //OrderedOptions bingo2 = new OrderedOptions(selection);
        //OrderedOptions bingo3 = new OrderedOptions(selection);

        ArrayList<OrderedOptions> bingo = new ArrayList<>();
        bingo.add(bingo1);
        //bingo.add(bingo2);
        //bingo.add(bingo3);

        model.addAttribute("bingoList", bingo);


        return "bingo/results";
    }

    @GetMapping("Edit")
    public String editBingoCard (Model model) {

        return "bingo/Edit";
    }

}
