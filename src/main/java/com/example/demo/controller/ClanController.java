package com.example.demo.controller;

import com.example.demo.entity.Clan;
import com.example.demo.entity.Jucator;
import com.example.demo.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class ClanController {

    @Autowired
    private ClanService clanService;

    @GetMapping("/clanuri")
    public List<Clan> findAllClanuri(){
        return clanService.findAllClanuri();
    }

    @PostMapping("/clanNou")
    public void create(@RequestBody Clan clan){
        clanService.create(clan);
    }

    //localhost:8080/info/update/%23CLN123
    @PutMapping("/clanuri/{clanUI}")
    public void update(@PathVariable String clanUI, @RequestBody Clan clan) {
        clanService.update(clanUI, clan);
    }

    @DeleteMapping("/deleteClan/{ClanUI}")
    public void delete(@PathVariable String ClanUI){
        clanService.delete(ClanUI);
    }

}
