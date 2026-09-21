package edu.proyecto.repository.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import edu.proyecto.entity.UsuarioEntity;
import edu.proyecto.repository.PersonaRepository;
import edu.proyecto.service.DTO.LoginRequestDto;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {
    private RestTemplate restTemplate;

    @Value("${uri.service.persona}")
    private String urlApiPersona;

    public PersonaRepositoryImpl(){
        restTemplate = new RestTemplate();
    }

    @Override
    public UsuarioEntity obtenerPorCredenciales(LoginRequestDto request) {
        System.out.println("request => " + request);
        String url = UriComponentsBuilder.fromHttpUrl(urlApiPersona + "/api/v1/usuarios/por-credenciales")
            .queryParam("idTipoPersona", request.getIdTipoPersona())
            .queryParam("idTipoDocIdentidad", request.getIdTipoDocIdentidad())
            .queryParam("nroDocumento", request.getNroDocumento())
            .queryParam("password", request.getPassword())
            .toUriString();
            System.out.println("url => " + url);
            // System.out.println(usuario);

        UsuarioEntity usuario = restTemplate.getForObject(url, UsuarioEntity.class);
        System.out.println("data => " + usuario);
        return usuario;
    }
}