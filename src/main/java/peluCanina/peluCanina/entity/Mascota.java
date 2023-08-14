package peluCanina.peluCanina.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import peluCanina.peluCanina.enums.Sino;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;  
    private String raza;
    private String color;

    private String alergico;
    private String atencionEspecial;
    private String observaciones;
    @ManyToOne @JoinColumn(name="duenio_id")
    private Duenio duenio;
}
