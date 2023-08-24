package peluCanina.peluCanina.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peluCanina.peluCanina.DTO.DTODuenio;
import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.service.IDuenioService;

@RestController
@RequestMapping("/duenios")
public class DuenioController {

    @Autowired
    IDuenioService duenSer;

    @PostMapping("/crear")
    public String crearDuenio(@RequestBody Duenio duen) {

        duenSer.crearDuenio(duen);
        return "El dueño se creó correctamente";
    }

    @GetMapping("/traer/{id}")
    public DTODuenio traerDuenio(@PathVariable Long id) {
        return duenSer.traerDuenioDTO(id);

    }

    @GetMapping("/listar")
    public List<DTODuenio> listarDuenio() {

        return duenSer.listarDueniosDTO();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarDuenio(@PathVariable Long id) {

        duenSer.borrarDuenio(id);
    }

    @PutMapping("/editar/{id}")
    public Duenio editarDuenio(@PathVariable Long id, @RequestParam String nombre,
            @RequestParam String celular, @RequestParam String direccion,
            @RequestParam List<Mascota> mascotas) {

        Duenio duen = new Duenio(id, nombre, celular, direccion, mascotas);

        duenSer.editarDuenio(duen);

        return duenSer.traerDuenio(id);

    }

}
