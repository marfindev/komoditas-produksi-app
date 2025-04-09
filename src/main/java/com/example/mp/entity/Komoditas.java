package com.example.mp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "komoditas")
public class Komoditas {

    @Id
    @Column(name = "komoditas_kode", length = 4)
    private String kode;

    @NotEmpty(message = "Nama Komoditas wajib diisi")
    @Size(max = 30, message = "Nama maksimal 30 karakter")
    @Column(name = "komoditas_nama", length = 30)
    private String nama;

    public Komoditas() {
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
