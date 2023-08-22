package peluCanina.peluCanina.service;

import java.util.List;
import peluCanina.peluCanina.entity.Mascota;

public interface IMascotaService {

    public void crearMascota(Mascota mas);

    public Mascota traerMascota(Long id);

    public List<Mascota> listarMascotas();

    public void borrarMascota(Long id);

    public void editarMascota(Mascota mas);

}
