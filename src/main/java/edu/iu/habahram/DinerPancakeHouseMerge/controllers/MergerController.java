package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> vegetarianItems = new ArrayList<>();
        for (MenuItemRecord item : items) {
            if (item.vegetarian()) {
                vegetarianItems.add(item);
            }
        }
        return vegetarianItems;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> breakfastItems = new ArrayList<>();
        for (MenuItemRecord item : items) {
            if (item.description() == "Breakfast") {
                breakfastItems.add(item);
            }
        }
        return breakfastItems;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> lunchItems = new ArrayList<>();
        for (MenuItemRecord item : items) {
            if (item.description() == "Lunch") {
                lunchItems.add(item);
            }
        }
        return lunchItems;
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getDinnerItems() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        List<MenuItemRecord> dinnerItems = new ArrayList<>();
        for (MenuItemRecord item  : items) {
            if (item.description() == "Dinner") {
                dinnerItems.add(item);
            }
        }
        return dinnerItems;
    }
}
