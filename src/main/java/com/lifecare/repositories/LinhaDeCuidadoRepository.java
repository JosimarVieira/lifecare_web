package com.lifecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifecare.domain.LinhaDeCuidado;

@Repository
public interface LinhaDeCuidadoRepository extends JpaRepository<LinhaDeCuidado, Integer> {

}
