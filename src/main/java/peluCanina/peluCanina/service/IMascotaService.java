package peluCanina.peluCanina.service;

import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.enums.Sino;
import peluCanina.peluCanina.exceptions.MiException;

import java.util.List;

public interface IMascotaService {

    public void crearMascota(Mascota mas) ;

    public Mascota traerMascota(Long id) ;

    public void borrarMascota(Long id) ;

    public List<Mascota> listarMascotas();

    public void editarMascota(Mascota mas) throws MiException;

    public Mascota getOne(Long id);

    public void validar(
            String nombre,
            String raza,
            String color,
            String alergico,
            String atencionEspecial,
            String observaciones,
            Duenio duenio) throws MiException;
}
