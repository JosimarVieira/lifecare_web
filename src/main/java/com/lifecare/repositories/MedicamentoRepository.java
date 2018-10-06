package com.lifecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifecare.domain.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

}
