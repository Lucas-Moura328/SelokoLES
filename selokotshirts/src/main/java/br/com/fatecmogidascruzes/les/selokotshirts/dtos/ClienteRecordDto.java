package br.com.fatecmogidascruzes.les.selokotshirts.dtos;

import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.GeneroModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.EmailModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteRecordDto(@NotBlank String nome, @NotBlank String cpf, LocalDate dataNascimento, @NotBlank String senha, @NotNull boolean ativo, @NotNull EmailModel email, @NotNull GeneroModel genero, @NotNull String ddd, @NotNull String telefone) {

}
