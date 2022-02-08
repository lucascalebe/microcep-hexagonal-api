package com.hexagonal.microcep.adaptersin.web;

import com.hexagonal.microcep.adaptersout.model.EnderecoModel;
import com.hexagonal.microcep.core.entities.Endereco;
import com.hexagonal.microcep.core.ports.in.BuscarEnderecoInputPort;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final BuscarEnderecoInputPort buscarEnderecoInputPort;

    EnderecoController(BuscarEnderecoInputPort buscarEnderecoInputPort) {
        this.buscarEnderecoInputPort = buscarEnderecoInputPort;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<?> buscarEndereco(@PathVariable String cep) {
        try {
            Endereco endereco = buscarEnderecoInputPort.buscarEndereco(cep);

            EnderecoModel enderecoModel = new EnderecoModel();
            BeanUtils.copyProperties(endereco,enderecoModel);

            return ResponseEntity.ok(enderecoModel);
        }
        catch (HttpClientErrorException.BadRequest e) {
            return ResponseEntity.badRequest().body("CEP inválido");
        }
    }
}
