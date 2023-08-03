package com.npsouza.helpdesk.repositories;

import com.npsouza.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChamadoRepository extends JpaRepository<Chamado, Integer> {

}
