package peluCanina.peluCanina.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.repository.IDuenioRepository;

@Service
public class DuenioService implements IDuenioService {
    
    @Autowired
    IDuenioRepository duenioRepo;
    
    @Override
    public void crearDuenio(Duenio duen) {
        
        duenioRepo.save(duen);
    }
    
    @Override
    public Duenio traerDuenio(Long id) {
        
        return duenioRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<Duenio> listarDuenios() {
        return duenioRepo.findAll();
    }
    
    @Override
    public void borrarDuenio(Long id) {
        duenioRepo.deleteById(id);
    }
    
    @Override
    public void editarDuenio(Duenio duen) {
        
        Duenio du = this.traerDuenio(duen.getId());
        
        du.setNombre(duen.getNombre());
        du.setCelular(duen.getCelular());
        du.setDireccion(duen.getDireccion());
        du.setMascotas(duen.getMascotas());
        
        this.crearDuenio(du);
    }
    
}
