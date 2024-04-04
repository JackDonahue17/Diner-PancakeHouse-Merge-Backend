package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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
    public MenuItem[] get() {
        MenuItem[] diner = dinerRepo.getTheMenu();
        List<MenuItem> pancake = pancakeRepo.getTheMenu();
        List<MenuItem> ans = new ArrayList<>(diner.length + pancake.size());
        ans.addAll(Arrays.asList(diner));
        ans.addAll(pancake);
        return ans.toArray(new MenuItem[0]);
    }
}
