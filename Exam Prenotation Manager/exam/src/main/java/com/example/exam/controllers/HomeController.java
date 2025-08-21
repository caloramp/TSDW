package com.example.exam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exam.models.Prenotazione;
import com.example.exam.repositories.PrenotazioneRepository;

@Controller
@RequestMapping("/")
public class HomeController {
    private final PrenotazioneRepository repo;

    public HomeController(PrenotazioneRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String getHome(Model model) {
        model.addAttribute("prenotazioni", repo.findAll());
        model.addAttribute("nPrenotazioni", repo.count());
        return "home";
    }

    @PostMapping
    public String postHome(Model model) {
        model.addAttribute("prenotazioni", repo.findAll());
        model.addAttribute("nPrenotazioni", repo.count());
        return "home";
    }
    @GetMapping("/effettuaPrenotazione")
    public String effettuaPrenotazione(Model model) {
        model.addAttribute("prenotazione", new Prenotazione());
        return "effettuaPrenotazione";
    }
    @PostMapping("/prenotazioneEffettuata")
    public String submit(@ModelAttribute Prenotazione p, Model model) {
        Prenotazione save = repo.save(p);
        model.addAttribute("prenotazione", save);
        return "prenotazioneEffettuata";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Prenotazione p = repo.getReferenceById(id);
        repo.delete(p);
        return "redirect:/";
    }

    @GetMapping("/prenotazione/{id}")
    public String prenotazioni(@PathVariable Long id, @ModelAttribute Prenotazione p, Model model) {
        Prenotazione old = repo.getReferenceById(id);
        
        model.addAttribute("prenotazioni", old);
        return "prenotazione";
    }
}
