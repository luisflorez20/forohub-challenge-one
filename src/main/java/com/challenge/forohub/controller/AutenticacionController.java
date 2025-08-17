package com.challenge.forohub.controller;

import com.challenge.forohub.domain.usuario.Usuario;
import com.challenge.forohub.domain.usuario.UsuarioRepository;
import com.challenge.forohub.infra.security.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datos.email(),
                datos.password()
        );

        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(jwtToken, tokenService.getExpirationTime()));
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datos) {
        // Verificar si el email ya está registrado
        if (usuarioRepository.existsByEmail(datos.email())) {
            return ResponseEntity.badRequest().body("El email ya está registrado");
        }

        // Crear nuevo usuario
        var usuario = new Usuario(
                datos.nombre(),
                datos.email(),
                passwordEncoder.encode(datos.password())
        );

        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}
