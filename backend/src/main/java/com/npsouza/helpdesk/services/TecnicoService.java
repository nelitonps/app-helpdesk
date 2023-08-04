package com.npsouza.helpdesk.services;

import com.npsouza.helpdesk.domain.Tecnico;
import com.npsouza.helpdesk.repositories.ITecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    //Implementa os serviços para a camada de Controle

    @Autowired
    private ITecnicoRepository tecnicoRepository; //Extende de JPA que ja possui diversos metodos inclusive o findById

    public Tecnico findByIdService(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElse(null); //Se não encontrar o objeto retorna null por enquanto
    }

}
