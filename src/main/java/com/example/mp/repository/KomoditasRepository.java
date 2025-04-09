package com.example.mp.repository;

import com.example.mp.entity.Komoditas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomoditasRepository extends JpaRepository<Komoditas, String> {
    Optional<Komoditas> findTopByOrderByKodeDesc();
}
