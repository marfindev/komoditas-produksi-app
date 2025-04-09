package com.example.mp.repository;

import com.example.mp.entity.Produksi;
import com.example.mp.entity.ProduksiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduksiRepository extends JpaRepository<Produksi, ProduksiId> {
    
    @Query(value = "SELECT EXTRACT(MONTH FROM p.tanggal) as bulan, SUM(p.produksi) as total " +
                   "FROM produksi p " +
                   "WHERE EXTRACT(YEAR FROM p.tanggal) = :tahun " +
                   "GROUP BY EXTRACT(MONTH FROM p.tanggal) " +
                   "ORDER BY bulan", nativeQuery = true)
    List<Object[]> findReportDataByYear(@Param("tahun") int tahun);
}
