package peluCanina.peluCanina.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peluCanina.peluCanina.repository.IMascotaRepository;

@Service
public class MascotaService {

    @Autowired
    IMascotaRepository mascoRepo;
}
