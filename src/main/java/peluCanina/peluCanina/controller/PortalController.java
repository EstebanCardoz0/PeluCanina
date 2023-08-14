/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peluCanina.peluCanina.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peluCanina.peluCanina.entity.Usuario;
import peluCanina.peluCanina.exceptions.MiException;
//import peluCanina.peluCanina.service.IUsuarioService;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/")
public class PortalController {

//    @Autowired
//    IUsuarioService usuSer;
//
//    @GetMapping("/")
//    public String index() {
//
//        return "index.html";
//    }
//
//    @GetMapping("/registrar")
//    public String registrar() {
//
//        return "registro.html";
//    }
//
//    @PostMapping("/registro")
//    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
//            @RequestParam String password2, ModelMap modelo) {
//
//        Usuario usu = new Usuario();
//        usu.setNombre(nombre);
//        usu.setEmail(email);
//        usu.setPassword(password);
//
//        try {
//            usuSer.registrar(usu, password2);
//            modelo.put("exito", "Usuario registrado correctamente");
//            return "index.html";
//        } catch (MiException ex) {
//
//            modelo.put("error", ex.getMessage());
//            return "registro.html";
//
//        }
//
//    }
//
//    @GetMapping("/login")
//    public String login() {
//
//        return "login.html";
//    }
//
}
