package com.crudSimples.service.impl;

import com.crudSimples.entity.UsuarioEntity;
import com.crudSimples.repository.UsuarioRepository;
import com.crudSimples.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity criar(UsuarioEntity usuarioEntity) {

        try {

            if ( nonNull( usuarioRepository.findTop1ByCpf(usuarioEntity.getCpf()) ) ) {
                throw new RuntimeException("O Cpf inserido ja pertence a outro usuário.");
            }
            if ( nonNull( usuarioRepository.findTop1ByEmail( usuarioEntity.getEmail()) )) {
                throw new RuntimeException("O E-mail inserido ja pertence a outro usuário.");
            }

            return usuarioRepository.save(usuarioEntity);

        }catch (Exception ee) {
            throw new RuntimeException(ee.getMessage());
            //Afim de ensinamento.
        }
    }

    @Override
    public void delete(BigInteger idUsuario) {
        this.buscarPorId(idUsuario);
        this.usuarioRepository.deleteById(idUsuario);
    }

    @Override
    @Transactional
    public UsuarioEntity editar(UsuarioEntity usuarioEntity) {

        return this.usuarioRepository.save(usuarioEntity);

    }

    @Override
    public UsuarioEntity buscarPorId(BigInteger idUsuario) {
        Optional
                .ofNullable(idUsuario)//ArgumentNotValidException
                .orElseThrow(() -> new RuntimeException("Id não pode ser nulo") );

        return this.usuarioRepository.findById(idUsuario)
                .orElseThrow( () -> new  RuntimeException("Cliente de id " + idUsuario + " não encontrado"));
    }

}
