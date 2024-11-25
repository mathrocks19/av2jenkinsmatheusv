package com.senac.br.Av2ProgWebMatheusV.repositories;

import com.senac.br.Av2ProgWebMatheusV.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}