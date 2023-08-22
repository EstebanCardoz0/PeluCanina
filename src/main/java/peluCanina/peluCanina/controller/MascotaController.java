package peluCanina.peluCanina.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.service.IMascotaService;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    IMascotaService mascoSer;

    @PostMapping("/crear")
    public String crearMascota(@RequestBody Mascota mas) {

        mascoSer.crearMascota(mas);
        return "La mascota se creó correctamente";
    }

    @GetMapping("/traer")
    public Mascota traerMascota(Long id) {
        return mascoSer.traerMascota(id);

    }

    @GetMapping("/listar")
    public List<Mascota> listarMascotas() {

        return mascoSer.listarMascotas();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarMascota(@PathVariable Long id) {

        mascoSer.borrarMascota(id);
    }

}//final
