package com.npsouza.helpdesk.services;

import com.npsouza.helpdesk.domain.Tecnico;
import com.npsouza.helpdesk.domain.dtos.TecnicoDTO;
import com.npsouza.helpdesk.repositories.ITecnicoRepository;
import com.npsouza.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    //Implementa os serviços para a camada de Controle

    @Autowired
    private ITecnicoRepository tecnicoRepository; //Extende de JPA que ja possui diversos metodos inclusive o findById

    public Tecnico findByIdService(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id)); //Se não encontrar o objeto retorna null por enquanto
    }

    public List<Tecnico> findAllService() {
        return tecnicoRepository.findAll();
    }

    public Tecnico createService(TecnicoDTO objDTO) { //Não se salva TecnicoDTO no banco de dados mas sim a Entidade que é o Tecnico
        objDTO.setId(null); //Por questões de segurança
        Tecnico newObj = new Tecnico(objDTO);
        return tecnicoRepository.save(newObj);
    }
}
