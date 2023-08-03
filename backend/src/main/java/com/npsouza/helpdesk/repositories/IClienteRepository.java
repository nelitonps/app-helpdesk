package com.npsouza.helpdesk.repositories;

import com.npsouza.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
