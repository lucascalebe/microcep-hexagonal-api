package com.hexagonal.microcep.core.usecases;

import com.hexagonal.microcep.core.ports.out.BuscarEnderecoOutputPort;
import com.hexagonal.microcep.core.entities.Endereco;
import com.hexagonal.microcep.core.ports.in.BuscarEnderecoInputPort;

public class BuscarEnderecoService implements BuscarEnderecoInputPort {


    private final BuscarEnderecoOutputPort buscarEnderecoOutputPort;

    public BuscarEnderecoService(BuscarEnderecoOutputPort buscarEnderecoOutputPort) {
        this.buscarEnderecoOutputPort = buscarEnderecoOutputPort;
    }

    @Override
    public Endereco buscarEndereco(String cep) {
        return buscarEnderecoOutputPort.buscarEndereco(cep);
    }
}
