package com.example.mp.controller;

import com.example.mp.entity.Produksi;
import com.example.mp.entity.ProduksiId;
import com.example.mp.repository.KomoditasRepository;
import com.example.mp.repository.ProduksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produksi")
public class ProduksiController {

    @Autowired
    private ProduksiRepository produksiRepository;

    @Autowired
    private KomoditasRepository komoditasRepository;

    @GetMapping
    public String list(Model model) {
        List<Produksi> list = produksiRepository.findAll();
        model.addAttribute("list", list);
        return "produksi/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Produksi produksi = new Produksi();
        model.addAttribute("produksi", produksi);
        model.addAttribute("komoditasList", komoditasRepository.findAll());
        return "produksi/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("produksi") Produksi produksi,
                       BindingResult bindingResult,
                       Model model) {
        if (produksi.getId() != null && produksiRepository.existsById(produksi.getId())) {
            bindingResult.reject("duplicate", "Data untuk tanggal dan komoditas sudah ada.");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("komoditasList", komoditasRepository.findAll());
            return "produksi/form";
        }
        produksiRepository.save(produksi);
        return "redirect:/produksi";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("tanggal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tanggal,
                           @RequestParam("komoditasKode") String komoditasKode,
                           Model model) {
        ProduksiId id = new ProduksiId(tanggal, komoditasKode);
        Optional<Produksi> opt = produksiRepository.findById(id);
        if (opt.isPresent()) {
            model.addAttribute("produksi", opt.get());
            model.addAttribute("komoditasList", komoditasRepository.findAll());
            return "produksi/form";
        }
        return "redirect:/produksi";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("tanggal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tanggal,
                         @RequestParam("komoditasKode") String komoditasKode,
                         Model model) {
        ProduksiId id = new ProduksiId(tanggal, komoditasKode);
        Optional<Produksi> opt = produksiRepository.findById(id);
        if (opt.isPresent()) {
            model.addAttribute("produksi", opt.get());
            return "produksi/detail";
        }
        return "redirect:/produksi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("tanggal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tanggal,
                         @RequestParam("komoditasKode") String komoditasKode) {
        ProduksiId id = new ProduksiId(tanggal, komoditasKode);
        produksiRepository.deleteById(id);
        return "redirect:/produksi";
    }
}
