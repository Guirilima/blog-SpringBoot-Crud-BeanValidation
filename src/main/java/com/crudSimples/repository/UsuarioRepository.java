package com.crudSimples.repository;

import com.crudSimples.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger> {

    public UsuarioEntity findTop1ByCpf(String cpf);

    public UsuarioEntity findTop1ByEmail(String email);

}
