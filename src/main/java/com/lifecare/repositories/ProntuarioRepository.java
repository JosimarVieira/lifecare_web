package com.lifecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifecare.domain.Prontuario;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {

}
