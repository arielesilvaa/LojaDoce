package com.example.LojaDoce.model.repository;

import com.example.LojaDoce.model.model.Doce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoceRepository extends JpaRepository<Doce, Integer> {
    // métodos prontos do JpaRepository: findAll, findById, save, deleteById, etc.
}
