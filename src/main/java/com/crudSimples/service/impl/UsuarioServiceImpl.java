package com.crudSimples.service.impl;

import com.crudSimples.entity.UsuarioEntity;
import com.crudSimples.repository.UsuarioRepository;
import com.crudSimples.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
