package com.example.mp.controller;

import com.example.mp.repository.ProduksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/laporan")
public class LaporanController {

    @Autowired
    private ProduksiRepository produksiRepository;

    @GetMapping
    public String laporanForm() {
        return "laporan/form";
    }

    @PostMapping
    public String generateReport(@RequestParam("tahun") int tahun, Model model) {
        List<Object[]> reportData = produksiRepository.findReportDataByYear(tahun);
        model.addAttribute("reportData", reportData);
        model.addAttribute("tahun", tahun);
        return "laporan/report";
    }
}
