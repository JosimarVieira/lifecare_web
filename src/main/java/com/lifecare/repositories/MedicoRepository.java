package com.lifecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifecare.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
