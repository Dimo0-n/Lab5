package com.example.demo.service;

import com.example.demo.entity.Jucator;
import com.example.demo.exceptions.AlreadyExistException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repository.JucatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.repository.JucatorRepository.randomUI;

@Service
public class JucatorService {
    @Autowired
    private JucatorRepository jucatorRepository;

    public List<Jucator> findAllJucatori(){
        return jucatorRepository.findAllJucatori();
    }

    public List<Jucator> cautareJucatori(String jucatorUI){
        if (!jucatorRepository.existByUI(jucatorUI))
            throw new NotFoundException("Not found Jucatori with UI: " + jucatorUI);

        return jucatorRepository.cautareJucatori(jucatorUI);
    }

    public void create(Jucator jucator) {
        String jucatorUI;
        do {
            jucatorUI = JucatorRepository.randomUI();
        } while (jucatorRepository.existUI(jucatorUI));

        String nickname = jucator.getNumeUtilizator();
        if (jucatorRepository.existByNickname(nickname)) {
            throw new AlreadyExistException("This nickname :" + nickname + " cannot be used");
        }
        jucatorRepository.create(jucator, jucatorUI);
    }

    public void update(String jucatorUI, Jucator jucator) {
        jucatorRepository.update(jucatorUI, jucator);
    }

    public void updateNickname(String JucatorUI, String numeNou) {
        Jucator jucator = new Jucator();  // Creați un obiect Jucator, eventual puteți seta alte atribute dacă este necesar
        jucatorRepository.updateNickname(jucator, JucatorUI, numeNou);
    }

    public void delete(String JucatorUI){
        jucatorRepository.delete(JucatorUI);
    }

}
