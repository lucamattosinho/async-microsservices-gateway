package com.example.ms_2.Repositories;

import com.example.ms_2.Entities.Clima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaRepository extends JpaRepository<Clima, Long> {

    Clima findByCidade(String cidade);

}