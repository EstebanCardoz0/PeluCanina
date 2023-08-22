package peluCanina.peluCanina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peluCanina.peluCanina.service.IDuenioService;

@RestController
@RequestMapping("/duenios")
public class DuenioController {
    
    @Autowired
    IDuenioService duenSer;

}
