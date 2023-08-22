package peluCanina.peluCanina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/duenio")
public class DuenioController {

<<<<<<< HEAD


=======
    @Autowired
    IDuenioService duenioSer;
    @Autowired
    IMascotaService mascoSer;

    @GetMapping("/alta")
    public String crearDuenio() {

        return "duenioAlta.html";
    }

    @PostMapping("/crear")
    public String crearDueni(@RequestParam String nombre,
            @RequestParam String celular, @RequestParam String direccion, ModelMap modelo) {

        Duenio duen = new Duenio();
        duen.setNombre(nombre);
        duen.setCelular(celular);
        duen.setDireccion(direccion);
        duen.setIdMascota(0L);
        duen.setNombreMascota("NO");

        duenioSer.crearDuenio(duen);
        modelo.put("éxito", "El dueño fue creado correctamente");

        return "duenioAlta.html";
    }

    @GetMapping("lista")
    public String lista(ModelMap modelo) {

        List<Duenio> duenios = duenioSer.listarDuenios();
        modelo.addAttribute("duenios", duenios);
        return "duenioLista.html";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, ModelMap modelo) {

        Duenio duen = duenioSer.traerDuenio(id);
//        List<Mascota> mascotas = duen.getMascotas();
//        modelo.addAttribute("mascotas", mascotas);

        modelo.put("duenio", duen);

        return "duenioEditar.html";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable Long id, String nombre, String celular, String direccion,
            Long idMascota, String nombreMascota, ModelMap modelo) {

        try {
            Duenio duen = new Duenio();
            duen.setId(id);
            duen.setCelular(celular);
            duen.setNombre(nombre);
            duen.setDireccion(direccion);
            duen.setIdMascota(idMascota);
            duen.setNombreMascota(nombreMascota);

            duenioSer.editarDuenio(duen);
            return "redirect:../lista";

        } catch (MiException e) {

            modelo.put("error", e.getMessage());
            return "duenioEditar.html";
        }

    }

    @GetMapping("/borrar/{id}")
    public String borrarDuenio(RedirectAttributes redirectAttributes, @PathVariable Long id, ModelMap modelo) throws MiException {

//        try {
//            Duenio duen = duenioSer.traerDuenio(id);
//            List<Mascota> mascotas = duen.getMascotas();
//            
//            for (Mascota mascota : mascotas) {
//                mascota.setDuenio(null);
//                mascoSer.editarMascota(mascota);
//                
//            }
//
        for (Mascota mascot : mascoSer.listarMascotas()) {
            if (mascot.getIdDuenio() == id) {
                mascot.setIdDuenio(null);
                mascot.setNombreDuenio(null);

                mascoSer.editarMascota(mascot);
            }
        }

        duenioSer.borrarDuenio(id);
        return "redirect:../lista";
//        } catch (MiException e) {
//
//            modelo.put("error", e.getMessage());
//            return "duenioLista.html";
//        }

    }
>>>>>>> 550ac97d4228a4bb63b365d32af4d007bdf27069

}
