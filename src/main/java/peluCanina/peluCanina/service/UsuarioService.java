package peluCanina.peluCanina.service;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import peluCanina.peluCanina.entity.Usuario;
//import peluCanina.peluCanina.exceptions.MiException;
//import peluCanina.peluCanina.repository.IUsuarioRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UsuarioService implements IUsuarioService, UserDetailsService {
//
//    @Autowired
//    private IUsuarioRepository usuRepo;
//
//    @Override
//    public void registrar(Usuario usuario, String password2) throws MiException {
//
//        validar(usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), password2);
//
//        usuRepo.save(usuario);
//
//
//    }
//
//    @Override
//    public void validar(String nombre, String email, String password, String password2) throws MiException {
//
//        if (nombre.isEmpty() || nombre == null) {
//
//            throw new MiException("El nombre no puede ser nulo o estar vacío");
//        }
//        if (email.isEmpty() || email == null) {
//
//            throw new MiException("El mail no puede ser nulo o estar vacío");
//        }
//        if (password.isEmpty() || password == null) {
//
//            throw new MiException("La contraseña no puede ser nula o estar vacía");
//        }
//        if (!password.equals(password2)) {
//
//            throw new MiException("Las contraseñas ingresadas no coinciden");
//        }
//
//
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        Usuario usu = usuRepo.buscarPorEmail(email);
//        if (usu != null) {
//            List<GrantedAuthority> permisos = new ArrayList<>();
//
//            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usu.getNombre().toString());
//
//            permisos.add(p);
//            return new User(usu.getEmail(), usu.getPassword(), permisos);
//
//
//        } else {
//
//            return null;
//        }
//    }
//}
