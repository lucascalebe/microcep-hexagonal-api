package com.hexagonal.microcep.core.ports.out;

import com.hexagonal.microcep.core.entities.Endereco;

public interface BuscarEnderecoOutputPort {
    Endereco buscarEndereco(String cep);
}
