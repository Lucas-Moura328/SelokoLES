package br.com.fatecmogidascruzes.les.selokotshirts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteRecordDto(@NotBlank String nome, @NotBlank String cpf, LocalDate dataNascimento, @NotBlank String senha, @NotNull boolean ativo, @NotBlank String email) {

}
