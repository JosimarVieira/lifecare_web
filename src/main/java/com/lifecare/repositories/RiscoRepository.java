package com.lifecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lifecare.domain.Risco;

@Repository
public interface RiscoRepository extends JpaRepository<Risco, Integer> {

}
