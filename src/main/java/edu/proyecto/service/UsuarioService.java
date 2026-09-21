package edu.proyecto.service;


import edu.proyecto.entity.UsuarioEntity;
import edu.proyecto.service.DTO.LoginRequestDto;

public interface UsuarioService {
    public UsuarioEntity validarUsuario(LoginRequestDto usuario);
}
