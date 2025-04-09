package com.example.mp.service;

import com.example.mp.entity.Komoditas;
import com.example.mp.repository.KomoditasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KomoditasService {

    @Autowired
    private KomoditasRepository komoditasRepository;

    public String generateKode() {
        Optional<Komoditas> lastKomoditas = komoditasRepository.findTopByOrderByKodeDesc();
        if (lastKomoditas.isPresent()) {
            String lastKode = lastKomoditas.get().getKode();
            int next = Integer.parseInt(lastKode.substring(1)) + 1;
            return String.format("K%03d", next);
        }
        return "K001";
    }
}
