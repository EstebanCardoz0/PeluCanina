package peluCanina.peluCanina.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.repository.IMascotaRepository;

@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    IMascotaRepository mascoRepo;
    
    @Override
    public void crearMascota(Mascota mas) {
        mascoRepo.save(mas);
    }
    
    @Override
    public Mascota traerMascota(Long id) {
        return mascoRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Mascota> listarMascotas() {
        return mascoRepo.findAll();
    }
    
    @Override
    public void borrarMascota(Long id) {
        mascoRepo.deleteById(id);
    }
    
    @Override
    public void editarMascota(Mascota mas) {
        
        Mascota masco = this.traerMascota(mas.getId());
        masco.setNombre(mas.getNombre());
        masco.setRaza(mas.getRaza());
        masco.setColor(mas.getColor());
        masco.setAlergico(mas.getAlergico());
        masco.setAtencionEspecial(mas.getAtencionEspecial());
        masco.setObservaciones(mas.getObservaciones());
        masco.setDuen(mas.getDuen());
        this.crearMascota(masco);
    }
}
