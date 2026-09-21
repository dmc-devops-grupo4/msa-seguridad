package edu.proyecto.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
    private Integer idUsuario;
    private Boolean verificado;
    private Date fechaVerificacion;
    private boolean activo;
    private Integer idPersona;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nroDocumento;
}