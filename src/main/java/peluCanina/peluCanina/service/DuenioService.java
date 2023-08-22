package peluCanina.peluCanina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peluCanina.peluCanina.repository.IDuenioRepository;

@Service
public class DuenioService {

    @Autowired
    IDuenioRepository duenioRepo;
}
