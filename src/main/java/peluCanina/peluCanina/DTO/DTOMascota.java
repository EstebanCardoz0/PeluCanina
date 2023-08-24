package peluCanina.peluCanina.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOMascota implements Serializable{


    private Long idDTOMascota;
    private String nombre;
    private String color;
    private String raza;
    private String atencionEspecial;
    private String alergico;
    private String observaciones;
    private String nombreDuenio;
    private String idDuenio;
}
