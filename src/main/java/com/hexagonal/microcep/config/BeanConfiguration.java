package com.hexagonal.microcep.config;

import com.hexagonal.microcep.core.ports.out.BuscarEnderecoOutputPort;
import com.hexagonal.microcep.core.usecases.BuscarEnderecoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    //sempre instanciar Bean de input, pois não tem framework no core.
    // O output que vem do parametro a anotação @Component já basta.
    @Bean
    public BuscarEnderecoService buscarEnderecoService(BuscarEnderecoOutputPort buscarEnderecoOutputPort) {
        return new BuscarEnderecoService(buscarEnderecoOutputPort);
    }
}
