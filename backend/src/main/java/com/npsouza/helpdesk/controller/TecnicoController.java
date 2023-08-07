package com.npsouza.helpdesk.controller;

import com.npsouza.helpdesk.domain.Tecnico;
import com.npsouza.helpdesk.domain.dtos.TecnicoDTO;
import com.npsouza.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAllController(){
        List<Tecnico> list = tecnicoService.findAllService();
        List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> createController(@RequestBody TecnicoDTO objDTO){
        Tecnico newObj = tecnicoService.createService(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
