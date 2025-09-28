package com.example.gestion_atenciones.security;

import com.example.gestion_atenciones.entity.Empleado;
import com.example.gestion_atenciones.entity.Paciente;
import com.example.gestion_atenciones.entity.Usuario;
import com.example.gestion_atenciones.repository.EmpleadoRepository;
import com.example.gestion_atenciones.repository.PacienteRepository;
import com.example.gestion_atenciones.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User; // org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final EmpleadoRepository empleadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Obtener id de la persona vinculada al usuario
        Long personaId = usuario.getPersona() != null ? usuario.getPersona().getId() : null;

        String role = null;

        if (personaId != null) {
            // Primero, buscar si esta persona es empleado (prioridad a empleado si ambas existieran)
            Optional<Empleado> empleadoOpt = empleadoRepository.findByPersona_Id(personaId);
            if (empleadoOpt.isPresent()) {
                // empleado.getRol() debería contener "MEDICO" o "ADMIN"
                role = empleadoOpt.get().getRol();
            } else {
                // si no es empleado, comprobar si es paciente
                Optional<Paciente> pacienteOpt = pacienteRepository.findByPersona_Id(personaId);
                if (pacienteOpt.isPresent()) {
                    role = "PACIENTE";
                }
            }
        }

        if (role == null || role.isBlank()) {
            throw new UsernameNotFoundException("No se pudo determinar rol para el usuario: " + username);
        }

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.toUpperCase());
        Collection<GrantedAuthority> authorities = Collections.singletonList(authority);

        return new User(usuario.getUsuario(), usuario.getContrasena(), authorities);
    }
}
