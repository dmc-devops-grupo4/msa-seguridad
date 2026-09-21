package edu.proyecto.repository;

import edu.proyecto.entity.UsuarioEntity;
import edu.proyecto.service.DTO.LoginRequestDto;

public interface PersonaRepository{
    public UsuarioEntity obtenerPorCredenciales(LoginRequestDto request);
}
