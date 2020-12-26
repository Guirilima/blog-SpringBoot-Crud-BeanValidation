package com.crudSimples.controller;

import com.crudSimples.entity.UsuarioEntity;
import com.crudSimples.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;

@RestController
@RequestMapping("/api/usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(path = "",produces = "application/json")
    public ResponseEntity criarNovoUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {

        log.debug("Iniciando Método.");

        try {
            usuarioService.criar( usuarioEntity );

            return ResponseEntity.ok(usuarioEntity);
        }catch (Exception ee) {
            log.debug("Erro durante o Salvamento do novo usuario.");
            return ResponseEntity.badRequest().body(ee.getMessage());
        }
    }

    @GetMapping(path = "/{idUsuario}",produces = "application/json")
    public ResponseEntity buscarUsuarioPorId(@PathVariable("idUsuario") BigInteger idUsuario) {

        try {
            UsuarioEntity usuarioEntity = usuarioService.buscarPorId( idUsuario );

            return ResponseEntity.ok(usuarioEntity);
        }catch (Exception ee) {
            return ResponseEntity.badRequest().body(ee.getMessage());
        }
    }

    @DeleteMapping(path = "/{idUsuario}",produces = "application/json")
    public ResponseEntity deletarPorId(@PathVariable("idUsuario") BigInteger idUsuario) {

        try {
            usuarioService.delete( idUsuario );

            return ResponseEntity.ok(null);
        }catch (Exception ee) {
            return ResponseEntity.badRequest().body(ee.getMessage());
        }
    }

    @PutMapping(path = "",produces = "application/json")
    public ResponseEntity editarUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {

        log.debug("Iniciando Método.");

        try {
            usuarioService.editar( usuarioEntity );

            return ResponseEntity.ok(usuarioEntity);
        }catch (Exception ee) {
            return ResponseEntity.badRequest().body(ee.getMessage());
        }
    }

}
