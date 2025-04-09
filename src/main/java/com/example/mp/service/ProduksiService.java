package com.example.mp.service;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mp.entity.Produksi;
import com.example.mp.entity.ProduksiId;
import com.example.mp.repository.ProduksiRepository;

@Service
public class ProduksiService {

    @Autowired
    private ProduksiRepository repo;
    
    public boolean isDuplicate(LocalDate tanggal, String komoditasKode) {
        ProduksiId id = new ProduksiId(tanggal, komoditasKode);
        return repo.existsById(id);
    }
    
    public void save(Produksi produksi) {
        repo.save(produksi);
    }
    
    public Iterable<Produksi> findAll(){
        return repo.findAll();
    }
    
    public Optional<Produksi> findById(LocalDate tanggal, String komoditasKode) {
        ProduksiId id = new ProduksiId(tanggal, komoditasKode);
        return repo.findById(id);
    }
    
    public void delete(Produksi produksi) {
        repo.delete(produksi);
    }
}
