package br.com.fatecmogidascruzes.les.selokotshirts.dtos;

import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.GeneroModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.EmailModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.TelefoneModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record ClienteRecordDto(@NotBlank String nome,
                               @NotBlank String cpf,
                               LocalDate dataNascimento,
                               @NotBlank String senha,
                               @NotNull boolean ativo,
                               @NotNull EmailModel email,
                               @NotNull GeneroModel genero,
                               @NotNull TelefoneModel telefone,
                               List<EnderecoRecordDto> enderecos) {

}
