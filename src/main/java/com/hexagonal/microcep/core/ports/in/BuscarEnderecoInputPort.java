package com.hexagonal.microcep.core.ports.in;

import com.hexagonal.microcep.core.entities.Endereco;

public interface BuscarEnderecoInputPort {
    Endereco buscarEndereco(String cep);
}
