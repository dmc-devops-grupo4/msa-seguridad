package edu.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.proyecto.entity.ErrorEntity;
import edu.proyecto.entity.UsuarioEntity;
import edu.proyecto.service.UsuarioService;
import edu.proyecto.service.DTO.LoginRequestDto;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/auth")
@Tag(name = "Usuario", description = "Api usuario")
public class LoginController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioEntity> validarUsuario(@RequestBody LoginRequestDto loginRequestDto) {
        UsuarioEntity usuarioValidado = usuarioService.validarUsuario(loginRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioValidado);

    }

    @ExceptionHandler(Exception.class)   ///obteniendo el error de excepcion en forma generica
    private ErrorEntity capturadorErrores(Exception ex){
        //capturando la excepcion - enviar el status en conflicto 409
        ErrorEntity error = new ErrorEntity(HttpStatus.CONFLICT.toString(), "Problema interno :)", "A ocurrido un error: "+ex.getMessage());
        return  error;
    }

}
