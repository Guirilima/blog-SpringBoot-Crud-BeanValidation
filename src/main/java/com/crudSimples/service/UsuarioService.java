package com.crudSimples.service;

import com.crudSimples.entity.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public interface UsuarioService {

    public UsuarioEntity criar(UsuarioEntity usuarioEntity) throws Exception;

    public void delete(BigInteger idUsuario) throws Exception;

    public UsuarioEntity editar(UsuarioEntity usuarioEntity);

    public UsuarioEntity buscarPorId(BigInteger idUsuario) throws Exception;

}
