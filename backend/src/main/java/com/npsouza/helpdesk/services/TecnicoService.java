package com.npsouza.helpdesk.services;

import com.npsouza.helpdesk.domain.Pessoa;
import com.npsouza.helpdesk.domain.Tecnico;
import com.npsouza.helpdesk.domain.dtos.TecnicoDTO;
import com.npsouza.helpdesk.repositories.IPessoaRepository;
import com.npsouza.helpdesk.repositories.ITecnicoRepository;
import com.npsouza.helpdesk.services.exceptions.DataIntegrityViolationException;
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
    @Autowired
    private IPessoaRepository pessoaRepository;


    public Tecnico findByIdService(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id)); //Se não encontrar o objeto retorna null por enquanto
    }

    public List<Tecnico> findAllService() {
        return tecnicoRepository.findAll();
    }

    public Tecnico createService(TecnicoDTO objDTO) { //Não se salva TecnicoDTO no banco de dados mas sim a Entidade que é o Tecnico
        objDTO.setId(null); //Por questões de segurança
        validaPorCPFeEmail(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return tecnicoRepository.save(newObj);
    }

    private void validaPorCPFeEmail(TecnicoDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("CPF ja cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail ja cadastrado no sistema!");
        }
    }
}
