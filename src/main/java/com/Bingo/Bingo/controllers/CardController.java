package com.Bingo.Bingo.controllers;

import com.Bingo.Bingo.data.BingoOptionRepository;
import com.Bingo.Bingo.data.ListData;
import com.Bingo.Bingo.data.BingoOptionsListRepository;
import com.Bingo.Bingo.models.OrderedOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("bingo")
public class CardController {

    @Autowired
    private BingoOptionRepository bingoOptionRepository;
    @Autowired
    private BingoOptionsListRepository bingoOptionsListRepository;

    ListData listData = new ListData();

    @GetMapping("create")
    //Shows form that crates bingo Cards
    public String createBingoCards (Model model) {

        return "bingo/create";

    }

    @GetMapping("view")
    //Show list of List to select from
    public String viewCardsList(Model model) {
        //model.addAttribute("listData", listData.getList());
        model.addAttribute("listData", bingoOptionsListRepository.findAll());
        return "bingo/view";
    }


    @GetMapping("results/{listPairId}")
    public String bingoCards(Model model, @PathVariable(name = "listPairId") Integer listPairId) {



        OrderedOptions bingo1 = new OrderedOptions(listData.getArray(listPairId).getArray());

        ArrayList<OrderedOptions> bingo = new ArrayList<>();
        bingo.add(bingo1);

        model.addAttribute("bingoList", bingo);
        return "bingo/results";
    }

    @GetMapping("Edit")
    public String editBingoCard (Model model) {
        model.addAttribute("list", listData.getList());

        return "bingo/Edit";
    }

    @PostMapping(value= "Edit/{listPairId}")
    public String displayEditListProcessing(Model model, @RequestParam(name = "listPairId") Integer listPairId) {
        model.addAttribute("list", listData.getList());
        model.addAttribute("items",listData.getArray(listPairId));

        return "bingo/Edit";
    }

}
