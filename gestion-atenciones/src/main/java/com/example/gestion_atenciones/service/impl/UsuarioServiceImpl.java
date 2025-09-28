package com.example.gestion_atenciones.service.impl;

import com.example.gestion_atenciones.entity.Usuario;
import com.example.gestion_atenciones.repository.UsuarioRepository;
import com.example.gestion_atenciones.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Usuario> buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        // Encriptar contraseña antes de persistir
        if (usuario.getContrasena() != null && !usuario.getContrasena().isBlank()) {
            usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public java.util.List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario u = usuarioExistente.get();
            u.setUsuario(usuario.getUsuario());
            if (usuario.getContrasena() != null && !usuario.getContrasena().isBlank()) {
                u.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
            }
            u.setPersona(usuario.getPersona());
            
            return usuarioRepository.save(u);
        } else {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
