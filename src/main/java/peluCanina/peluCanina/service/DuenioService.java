package peluCanina.peluCanina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.exceptions.MiException;
import peluCanina.peluCanina.repository.IDuenioRepository;

import java.util.List;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    IDuenioRepository duenioRepo;

    @Override
    @Transactional
    public void crearDuenio(Duenio duen) {

        duenioRepo.save(duen);
    }

    @Override
    @Transactional
    public void borrarDuenio(Long id) {
        duenioRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void editarDuenio(Duenio duen) throws MiException {

//        validar(duen.getNombre(), duen.getCelular(), duen.getDireccion(), duen.getMascotas());
        this.crearDuenio(duen);

    }

    @Override
    public List<Duenio> listarDuenios() {

        return duenioRepo.findAll();
    }

    @Override
    @Transactional
    public Duenio traerDuenio(Long id) {

        return duenioRepo.findById(id).orElse(null);

    }

    @Override
    public void validar(String nombre, String celular, String direccion, List<Mascota> listaMasco) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede ser nulo o estar vacío");
        }
        if (celular.isEmpty() || celular == null) {
            throw new MiException("El celular no puede ser nulo o estar vacío");
        }
        if (direccion.isEmpty() || direccion == null) {
            throw new MiException("La dirección no puede ser nula o estar vacía");
        }
        if (listaMasco == null) {
            throw new MiException("La lista de mascotas no puede ser nula ");
        }

    }

    @Override
    @Transactional
    public List<Duenio> listarDueniosConMascotas() {
//        return duenioRepo.findAllWithMascotas();
        return null;
    }
}
