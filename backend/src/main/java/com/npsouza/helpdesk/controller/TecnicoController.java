package com.npsouza.helpdesk.controller;

import com.npsouza.helpdesk.domain.Tecnico;
import com.npsouza.helpdesk.domain.dtos.TecnicoDTO;
import com.npsouza.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {
    //EndPoint
    //localhost:8080/tecnicos/id

    //Injetar os serviços criados nas classes service
    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}") //Usando variavel de Path
    public ResponseEntity<TecnicoDTO> findByIdController(@PathVariable Integer id){ //Quando usa variavel de Path tem que usar @PathVariable
        Tecnico obj = tecnicoService.findByIdService(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj)); //No body(corpo dessa resposta) o objeto
    }

}
