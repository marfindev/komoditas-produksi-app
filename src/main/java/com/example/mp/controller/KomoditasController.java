package com.example.mp.controller;

import com.example.mp.entity.Komoditas;
import com.example.mp.repository.KomoditasRepository;
import com.example.mp.service.KomoditasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/komoditas")
public class KomoditasController {

    @Autowired
    private KomoditasRepository komoditasRepository;

    @Autowired
    private KomoditasService komoditasService;

    @GetMapping
    public String list(Model model) {
        List<Komoditas> list = komoditasRepository.findAll();
        model.addAttribute("list", list);
        return "komoditas/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Komoditas komoditas = new Komoditas();
        komoditas.setKode(komoditasService.generateKode());
        model.addAttribute("komoditas", komoditas);
        return "komoditas/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("komoditas") Komoditas komoditas,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "komoditas/form";
        }
        komoditasRepository.save(komoditas);
        return "redirect:/komoditas";
    }

    @GetMapping("/edit/{kode}")
    public String editForm(@PathVariable("kode") String kode, Model model) {
        Optional<Komoditas> opt = komoditasRepository.findById(kode);
        if (opt.isPresent()) {
            model.addAttribute("komoditas", opt.get());
            return "komoditas/form";
        }
        return "redirect:/komoditas";
    }

    @GetMapping("/detail/{kode}")
    public String detail(@PathVariable("kode") String kode, Model model) {
        Optional<Komoditas> opt = komoditasRepository.findById(kode);
        if (opt.isPresent()) {
            model.addAttribute("komoditas", opt.get());
            return "komoditas/detail";
        }
        return "redirect:/komoditas";
    }

    @GetMapping("/delete/{kode}")
    public String delete(@PathVariable("kode") String kode) {
        komoditasRepository.deleteById(kode);
        return "redirect:/komoditas";
    }
}
