package com.crudSimples.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger idUsuario;

    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 3,max = 50,message = "O nome precisar ser entre 3 a 50 caracteres")
    @Column(length = 50)/*Validação lado do Banco*/
    private String nome;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    @Past
    @NotNull
    private Date dtNascimento;

}
