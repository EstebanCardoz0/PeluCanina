package peluCanina.peluCanina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.enums.Sino;
import peluCanina.peluCanina.exceptions.MiException;
import peluCanina.peluCanina.repository.IMascotaRepository;

import java.util.List;

@Service

public class MascotaService implements IMascotaService {

    @Autowired
    IMascotaRepository mascoRepo;

    @Override
    @Transactional
    public void crearMascota(Mascota mas) {

        mascoRepo.save(mas);

    }

    @Override
    public Mascota traerMascota(Long id) {

        return mascoRepo.findById(id).orElse(null);

    }

    @Override
    @Transactional
    public void borrarMascota(Long id) {
        mascoRepo.deleteById(id);

    }

    @Override
    public List<Mascota> listarMascotas() {

        return mascoRepo.findAll();
    }

    @Override
    @Transactional
    public void editarMascota(Mascota mas) throws MiException {

//        validar(mas.getNombre(), mas.getRaza(), mas.getColor(), mas.getAlergico(),
//                mas.getAtencionEspecial(), mas.getObservaciones(), mas.getDuenio());

//        this.traerMascota(mas.getId()).setNombre(mas.getNombre());
//        this.traerMascota(mas.getId()).setRaza(mas.getRaza());
//        this.traerMascota(mas.getId()).setColor(mas.getColor());
//        this.traerMascota(mas.getId()).setAlergico(mas.getAlergico());
//        this.traerMascota(mas.getId()).setAtencionEspecial(mas.getAtencionEspecial());
//        this.traerMascota(mas.getId()).setDuenio(mas.getDuenio());
//        this.traerMascota(mas.getId()).setObservaciones(mas.getObservaciones());


        this.crearMascota(mas);

    }

    @Override
    public Mascota getOne(Long id) {
        return mascoRepo.getOne(id);

    }

    @Override
    public void validar(String nombre,
                        String raza,
                        String color,
                        String alergico,
                        String atencionEspecial,
                        String observaciones,
                        Duenio duenio) throws MiException {

        if (raza.isEmpty() || raza == null) {
            throw new MiException("La raza no puede ser nula o estar vacía");
        }
        if (color.isEmpty() || color == null) {
            throw new MiException("El color no puede ser nulo o estar vacío");
        }
        if (observaciones.isEmpty() || observaciones == null) {
            throw new MiException("El campo Observaciones no puede ser nulo o estar vacío");
        }
        if (duenio == null) {
            throw new MiException("Se debe indicar el dueño de la mascota");
        }
        if (alergico == null) {
            throw new MiException("Se debe especificar si la mascota es alérgica o no");
        }
        if (atencionEspecial == null) {
            throw new MiException("Se debe especificar si la mascota necesita atención especial o no");
        }

    }
}
