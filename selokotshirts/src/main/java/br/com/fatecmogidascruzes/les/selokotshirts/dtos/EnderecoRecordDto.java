package br.com.fatecmogidascruzes.les.selokotshirts.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EnderecoRecordDto(UUID idCliente,
                                @NotBlank String logradouro,
                                @NotNull int numero,
                                String complemento,
                                @NotBlank String bairro,
                                @NotBlank String estado,
                                @NotBlank String municipio,
                                @NotBlank String cep,
                                @NotNull boolean entrega) {
}
