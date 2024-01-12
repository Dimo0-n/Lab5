package com.example.demo.service;

import com.example.demo.entity.Clan;
import com.example.demo.entity.Jucator;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.ClanRepository;
import com.example.demo.repository.JucatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClanService {

    @Autowired
    private ClanRepository clanRepository;

    public List<Clan> findAllClanuri(){
        return clanRepository.findAllClanuri();
    }

    public void create(Clan clan) {
        String clanUI;
        do {
            clanUI = clanRepository.randomUI();
        } while (clanRepository.existUI(clanUI));

        clanRepository.create(clan, clanUI);
    }

    public void update(String clanUI, Clan clan) {
        clanRepository.update(clanUI, clan);
    }

    public void delete(String ClanUI){
        clanRepository.delete(ClanUI);
    }

}
