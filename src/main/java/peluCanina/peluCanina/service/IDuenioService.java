package peluCanina.peluCanina.service;

import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.exceptions.MiException;

import java.util.List;

public interface IDuenioService {

    public void crearDuenio(Duenio duen);

    public void borrarDuenio(Long id);

    public void editarDuenio(Duenio duen) throws MiException;

    public List<Duenio> listarDuenios();

    public Duenio traerDuenio(Long id);

    public void validar(String nombre, String celular, String direccion, List<Mascota> listaMasco) throws MiException;


    public List<Duenio> listarDueniosConMascotas();
}
