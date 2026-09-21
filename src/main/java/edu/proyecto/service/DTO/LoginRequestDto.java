package edu.proyecto.service.DTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private Integer idTipoPersona;
    private Integer idTipoDocIdentidad;
    private String nroDocumento; 
    private String password;
}
