package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    DinerRepository dinerRepo;
    PancakeHouseRepository pancakeRepo;

    public MergerController(DinerRepository dinerRepo, PancakeHouseRepository pancakeRepo) {
        this.dinerRepo = dinerRepo;
        this.pancakeRepo = pancakeRepo;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        Iterator<MenuItem> lunchItems = dinerRepo.getTheMenuIterator();
        while(lunchItems.hasNext()) {
            menuItems.add(lunchItems.next());
        }

        Iterator<MenuItem> breakfastItems = pancakeRepo.getTheMenuIterator();
        while(breakfastItems.hasNext()) {
            menuItems.add(breakfastItems.next());
        }
        return menuItems;
    }
}
