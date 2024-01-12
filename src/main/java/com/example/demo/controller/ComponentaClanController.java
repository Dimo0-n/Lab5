package com.example.demo.controller;


import com.example.demo.entity.ComponentaClan;
import com.example.demo.service.ComponentaClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class ComponentaClanController {

    @Autowired
    private ComponentaClanService componentaClanService;

    @GetMapping("/clanuri/componenta")
    public List<ComponentaClan> findAllComponentaClan(){
        return componentaClanService.findAllComponentaClan();
    }

    @PostMapping("/actualizareClan")
    public void create(@RequestBody ComponentaClan componentaClan){
        componentaClanService.create(componentaClan);
    }

    @PutMapping("/componentaClan/{clanUI}")
    public void update(@PathVariable String clanUI, @RequestBody ComponentaClan componentaClan){
        componentaClanService.update(componentaClan, clanUI);
    }

    @DeleteMapping("/deleteComponentaClan/{clanUI}")
    public void delete(@PathVariable String clanUI){
        componentaClanService.delete(clanUI);
    }

}
