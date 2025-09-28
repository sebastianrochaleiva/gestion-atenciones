package com.example.gestion_atenciones.service;

import com.example.gestion_atenciones.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> obtenerPorId(Long id);
    Optional<Usuario> buscarPorUsuario(String usuario);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}

