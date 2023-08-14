package peluCanina.peluCanina.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String celular;
    private String direccion;

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)


    private List<Mascota> mascotas;
}
