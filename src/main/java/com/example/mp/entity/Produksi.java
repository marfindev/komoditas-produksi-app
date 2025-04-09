package com.example.mp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "produksi")
public class Produksi {

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    @EmbeddedId
    private ProduksiId id;

    @NotNull(message = "Jumlah produksi wajib diisi")
    @Column(name = "produksi")
    private Long produksi;

    @ManyToOne
    @JoinColumn(name = "komoditas_kode", insertable = false, updatable = false)
    private Komoditas komoditas;

    public Produksi() {
    }

    public ProduksiId getId() {
        return id;
    }

    public void setId(ProduksiId id) {
        this.id = id;
    }

    public Long getProduksi() {
        return produksi;
    }

    public void setProduksi(Long produksi) {
        this.produksi = produksi;
    }

    public Komoditas getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(Komoditas komoditas) {
        this.komoditas = komoditas;
    }
}
