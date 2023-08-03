package com.npsouza.helpdesk.services;

import com.npsouza.helpdesk.domain.Chamado;
import com.npsouza.helpdesk.domain.Cliente;
import com.npsouza.helpdesk.domain.Tecnico;
import com.npsouza.helpdesk.domain.enums.Perfil;
import com.npsouza.helpdesk.domain.enums.Prioridade;
import com.npsouza.helpdesk.domain.enums.Status;
import com.npsouza.helpdesk.repositories.IChamadoRepository;
import com.npsouza.helpdesk.repositories.IClienteRepository;
import com.npsouza.helpdesk.repositories.ITecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBServices {

    //Injetando dependencias das interfaces
    @Autowired
    private ITecnicoRepository tecnicoRepository;
    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IChamadoRepository chamadoRepository;

    public void instanciaDB(){

        Tecnico tec1 = new Tecnico(null, "Mauro Silva", "15465126548", "mauro@gmail.com", "123");
        tec1.addPerfis(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Lair Oliveira", "75465126523", "lair@gmail.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
