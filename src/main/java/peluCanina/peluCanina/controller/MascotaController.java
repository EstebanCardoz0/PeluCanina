package peluCanina.peluCanina.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascota")
public class MascotaController {



    @GetMapping("/hola")
    public String hola(){

        return "hola esto es una prueba";
    }


<<<<<<< HEAD
=======
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
>>>>>>> 550ac97d4228a4bb63b365d32af4d007bdf27069

}//final
