package edu.proyecto.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.proyecto.entity.UsuarioEntity;
import edu.proyecto.repository.PersonaRepository;
import edu.proyecto.service.UsuarioService;
import edu.proyecto.service.DTO.LoginRequestDto;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private PersonaRepository personaRepository; 

    @Override
    public UsuarioEntity validarUsuario(LoginRequestDto request) {
        UsuarioEntity usuario = personaRepository.obtenerPorCredenciales(request);  

        if(usuario == null || usuario.getIdUsuario() == 0){
            throw new RuntimeException("El usuario no existe. O las credenciales ingresadas son incorrectas");
        }

        return usuario;
    }
    
}
