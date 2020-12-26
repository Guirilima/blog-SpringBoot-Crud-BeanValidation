package com.crudSimples.service;

import com.crudSimples.entity.UsuarioEntity;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    public UsuarioEntity criar(UsuarioEntity usuarioEntity) ;

}
