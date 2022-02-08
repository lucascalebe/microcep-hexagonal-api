package com.hexagonal.microcep.adaptersout.rest;

import com.hexagonal.microcep.core.ports.out.BuscarEnderecoOutputPort;
import com.hexagonal.microcep.core.entities.Endereco;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class BuscarEnderecoImpl implements BuscarEnderecoOutputPort {

    private final String URI = "http://viacep.com.br/ws/{cep}/json/";

    @Override
    public Endereco buscarEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();
        params.put("cep", cep);

        return restTemplate.getForObject(URI, Endereco.class, params);
    }
}
