package peluCanina.peluCanina.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mascota")
public class MascotaController {



    @GetMapping("/hola")
    public String hola(){

        return "hola esto es una prueba";
    }



}//final
