package com.Bingo.Bingo.controllers;

import com.Bingo.Bingo.data.BingoCardRepository;
import com.Bingo.Bingo.data.BingoOptionRepository;
import com.Bingo.Bingo.data.ListData;
import com.Bingo.Bingo.data.BingoOptionsListRepository;
import com.Bingo.Bingo.models.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("bingo")
public class CardController {

    @Autowired
    private BingoOptionRepository bingoOptionRepository;
    @Autowired
    private BingoOptionsListRepository bingoOptionsListRepository;
    @Autowired
    private BingoCardRepository bingoCardRepository;

    ListData listData = new ListData();

    @GetMapping("create")
    //Shows form that crates bingo Cards
    public String createBingoCards (Model model) {

        return "bingo/create";

    }

    @GetMapping("view")
    public String viewCardsList(Model model) {
        List<BingoOptionsList> bingoOptionsLists = new ArrayList<>();
        bingoOptionsListRepository.findAll().forEach(bingoOptionsLists::add); // Convert Iterable to List

        System.out.println("Bingo Lists Loaded: " + bingoOptionsLists);  // Debugging

        model.addAttribute("bingoOptionsList", bingoOptionsLists);
        return "bingo/view";
    }

    @GetMapping("bingoLists")
    public String bingoListIndex(Model model) {
        model.addAttribute("bingolist", bingoOptionsListRepository.findAll());
        model.addAttribute(new BingoOptionsList());

        return "bingo/bingoLists";
    }

    @PostMapping("bingoLists")
    public String processNewBingoList(Model model, @ModelAttribute @Valid BingoOptionsList newBingoOptionsList,
                                      Errors errors) {
        if(errors.hasErrors()){
            return "bingo/bingoLists";
        }
        bingoOptionsListRepository.save(newBingoOptionsList);
        return "redirect:/bingo/bingoLists";
    }

    @GetMapping("bingoListEdit/{bingoOptionsListId}")
    public String bingoListEdit (Model model, @PathVariable int bingoOptionsListId) {
        model.addAttribute("bingoOptions", bingoOptionRepository.findAll());

        Optional<BingoOptionsList> optionalBingoOptionsList = bingoOptionsListRepository.findById(bingoOptionsListId);
        if (optionalBingoOptionsList.isPresent()){
            BingoOptionsList bingoOptionsList = (BingoOptionsList) optionalBingoOptionsList.get();
            model.addAttribute("listName", bingoOptionsList);



            return "bingo/bingoListEdit";
        }


        return "/bingo/bingoListEdit";
    }

    @PostMapping("bingoListEdit")
    public String processBingoListEdit(Model model,
                                       @RequestParam(required = false) List<Integer> bingoOption,
                                       @ModelAttribute BingoOptionsList bingoOptionsList,
                                       @RequestParam int bingoOptionsListId) {

        Optional<BingoOptionsList> optionalBingoOptionsList = bingoOptionsListRepository.findById(bingoOptionsListId);

        if (optionalBingoOptionsList.isPresent()) {
            BingoOptionsList existingBingoOptionsList = optionalBingoOptionsList.get();

            // Ensure bingoOption is not null by using an empty list as default
            List<BingoOption> bingoOptionObject = (List<BingoOption>) bingoOptionRepository.findAllById(
                    bingoOption != null ? bingoOption : Collections.emptyList()
            );

            existingBingoOptionsList.setBingoOptionsList(bingoOptionObject);
            bingoOptionsListRepository.save(existingBingoOptionsList);

            return "redirect:/bingo/bingoListEdit/" + bingoOptionsListId; // Redirect to the same edit page
        }

        model.addAttribute("error", "Bingo List not found!");
        return "bingo/bingoListEdit";
    }




    @GetMapping("bingoOptions")
    public String bingoOptions(Model model) {
        model.addAttribute("bOptions", bingoOptionRepository.findAll());
        model.addAttribute("bingoOptionsList", bingoOptionsListRepository.findAll());
        model.addAttribute("bingoOption",new BingoOption());

        return "bingo/bingoOptions";
    }

    @PostMapping("bingoOptions")
    public String processNewBingoOption(Model model,
                                        @ModelAttribute @Valid BingoOption newBingoOption,
                                        Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("error", "new error message.");
            return "/bingo/bingoOptions";
        }

        bingoOptionRepository.save(newBingoOption);

        return "redirect:/bingo/bingoOptions";
    }



    @GetMapping("results/{bingoOptionsListId}")
    public String bingoCards(Model model, @PathVariable Integer bingoOptionsListId) {

        Optional<BingoOptionsList> optionalBingoOptionsList = bingoOptionsListRepository.findById(bingoOptionsListId);
        if (optionalBingoOptionsList.isPresent()){
            BingoOptionsList bingoOptionsList = (BingoOptionsList) optionalBingoOptionsList.get();

            //Ensure safe conversion to a ArrayList
            List<BingoOption> optionList = bingoOptionsList.getBingoOptionsList();
            ArrayList<BingoOption> bingoOptions = new ArrayList<>(optionList != null? optionList : Collections.emptyList());

            BingoCardGen bingo1 = new BingoCardGen(bingoOptions);
            BingoCard bingoCard = new BingoCard(bingo1.getBingoCards());

            bingoCard.setBingoOptionsList(bingoOptionsList);
            bingoCardRepository.save(bingoCard);

            model.addAttribute("bingoList", bingoCard);
            return "bingo/results";
        }

        model.addAttribute("error", "Bingo list not found");
        return "bingo/results";
    }

    @GetMapping("bingoCard/{bingoCardId}")
    public String bingoCard(Model model, @PathVariable Integer bingoCardId) {

        Optional<BingoCard> optionalBingoCard = bingoCardRepository.findById(bingoCardId);
        if (optionalBingoCard.isPresent()) {
            BingoCard bingoCard = (BingoCard) optionalBingoCard.get();

            model.addAttribute("bingoList", bingoCard);

            return "bingo/bingoCard";
        }

        return "bingo/bingoCard";
    }

    @GetMapping("Edit")
    public String editBingoCard (Model model) {


        model.addAttribute("bingoOptionsList", bingoOptionsListRepository.findAll());

        return "bingo/Edit";
    }


}
