package com.example.demo.service;

import com.example.demo.entity.Clan;
import com.example.demo.entity.ComponentaClan;
import com.example.demo.repository.ClanRepository;
import com.example.demo.repository.ComponentaClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentaClanService {

    @Autowired
    private ComponentaClanRepository componentaClanRepository;

    public List<ComponentaClan> findAllComponentaClan(){
        return componentaClanRepository.findAllComponentaClan();
    }

    public void create(ComponentaClan componentaClan){
        componentaClanRepository.create(componentaClan);
    }

    public void update(ComponentaClan componentaClan, String clanUI){
        componentaClanRepository.update(componentaClan, clanUI);
    }

    public void delete(String clanUI){
        componentaClanRepository.delete(clanUI);
    }

}
