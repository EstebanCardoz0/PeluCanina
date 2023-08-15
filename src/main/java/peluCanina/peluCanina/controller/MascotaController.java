package peluCanina.peluCanina.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import peluCanina.peluCanina.entity.Duenio;
import peluCanina.peluCanina.entity.Mascota;
import peluCanina.peluCanina.enums.Sino;
import peluCanina.peluCanina.service.IDuenioService;
import peluCanina.peluCanina.service.IMascotaService;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import peluCanina.peluCanina.exceptions.MiException;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    IMascotaService mascoSer;

    @Autowired
    IDuenioService duenioSer;

    @GetMapping("/alta")
    public String crearMascota(ModelMap modelo) {
        List<Duenio> duenios = duenioSer.listarDuenios();

        modelo.addAttribute("duenios", duenios);

        return "mascotaAlta.html";
    }

    @PostMapping("/crear")
    public String crearMascota(@RequestParam String nombre, @RequestParam String color, @RequestParam String raza,
            @RequestParam String alergico, @RequestParam String atencionEspecial,
            @RequestParam String observaciones, @RequestParam(required = false) Duenio duenio,
            ModelMap modelo) {

        Mascota mas = new Mascota();
        mas.setNombre(nombre);
        mas.setColor(color);
        mas.setRaza(raza);

        mas.setAlergico(alergico);
        mas.setAtencionEspecial(atencionEspecial);

        mas.setObservaciones(observaciones);

        mas.setIdDuenio(duenio.getId());
        mas.setNombreDuenio(duenio.getNombre());

        mascoSer.crearMascota(mas);

        modelo.put("exito", "mascota creada correctamente");

        List<Duenio> duenios = duenioSer.listarDuenios();

        modelo.addAttribute("duenios", duenios);

        return "mascotaAlta.html";
    }

    @GetMapping("/lista")
    public String lista(ModelMap modelo) {

        List<Mascota> mascotas = mascoSer.listarMascotas();

        modelo.addAttribute("mascotas", mascotas);

        return "mascotaLista.html";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {

        List<Duenio> duenios = duenioSer.listarDuenios();

        modelo.addAttribute("duenios", duenios);

        modelo.put("mascota", mascoSer.traerMascota(id));

        return "mascotaEditar.html";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id, String nombre, String raza, String color, String observaciones,
            String alergico, String atencionEspecial, Duenio duenio, ModelMap modelo) {

        try {
            Mascota mas = new Mascota(id, nombre, raza, color, alergico, atencionEspecial,
                    observaciones, duenio.getIdMascota(), duenio.getNombreMascota());

            mascoSer.editarMascota(mas);

            Duenio duen = duenio;
            System.out.println("duen 1111" + duen.toString());
            duen.setIdMascota(id);
            duen.setNombreMascota(nombre);

            duenioSer.editarDuenio(duen);

            System.out.println("duen 2" + duen.toString());

            modelo.put("exito", "mascota editada correctamente");
            return "redirect:../lista";

        } catch (MiException e) {

            modelo.put("error", e.getMessage());
            return "mascotaEditar.html";
        }

    }

    //    @PostMapping("/borrar/{id}")
//    public String borrar(@PathVariable Long id) {
//
//        mascoSer.borrarMascota(id);
//        
//            return "redirect:../lista";
//    }
    @GetMapping("/borrar/{id}")
    public String borarMascota(RedirectAttributes redirectAttributes, @PathVariable Long id) {

        mascoSer.borrarMascota(id);
//        redirectAttributes.addFlashAttribute("deleted", "Autor borrado");
        return "redirect:../lista";
    }

}//final
