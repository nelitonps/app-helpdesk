package com.npsouza.helpdesk.repositories;

import com.npsouza.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaRepository extends JpaRepository<Pessoa, Integer> {

}
