package com.npsouza.helpdesk.repositories;

import com.npsouza.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
