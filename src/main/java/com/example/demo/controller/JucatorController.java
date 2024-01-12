package com.example.demo.controller;

import com.example.demo.entity.Jucator;
import com.example.demo.service.JucatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class JucatorController {

        @Autowired
        private JucatorService jucatorService;

        @GetMapping("/jucatori")
        public List<Jucator> findAllJucatori(){
            return jucatorService.findAllJucatori();
        }

        @GetMapping("/cautare")
        public List<Jucator> cautareJucatori(@RequestParam String jucatorUI) {
                return jucatorService.cautareJucatori(jucatorUI);
        }

        @PostMapping("/jucatorNou")
        @ResponseStatus(HttpStatus.CREATED)
        public void create(@RequestBody Jucator jucator) {
                jucatorService.create(jucator);
        }

        //localhost:8080/info/jucatori/%23UV5W6X7Y8
        @PutMapping("/jucatori/{jucatorUI}")
        public void update(@PathVariable String jucatorUI, @RequestBody Jucator jucator) {
                jucatorService.update(jucatorUI, jucator);
        }

        @PutMapping("/nickname")
        public void updateNickname(@RequestParam String JucatorUI, @RequestParam String numeNou) {
                jucatorService.updateNickname(JucatorUI, numeNou);
        }

        ///info/jucatori/%23XY9Z8W7V6
        @DeleteMapping("/deleteJucator/{JucatorUI}")
        public void delete(@PathVariable String JucatorUI){
                jucatorService.delete(JucatorUI);
        }

}
