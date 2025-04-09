package com.example.mp.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Objects;

@Embeddable
public class ProduksiId implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    @Column(name = "tanggal")
    private LocalDate tanggal;

    @Column(name = "komoditas_kode", length = 4)
    private String komoditasKode;

    public ProduksiId() {
    }

    public ProduksiId(LocalDate tanggal, String komoditasKode) {
        this.tanggal = tanggal;
        this.komoditasKode = komoditasKode;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getKomoditasKode() {
        return komoditasKode;
    }

    public void setKomoditasKode(String komoditasKode) {
        this.komoditasKode = komoditasKode;
    }
    
    @Override
    public boolean equals(Object o){
         if(this == o) return true;
         if(o==null || getClass() != o.getClass()) return false;
         ProduksiId that = (ProduksiId) o;
         return Objects.equals(tanggal, that.tanggal) 
                && Objects.equals(komoditasKode, that.komoditasKode);
    }
    
    @Override
    public int hashCode(){
         return Objects.hash(tanggal, komoditasKode);
    }
}
