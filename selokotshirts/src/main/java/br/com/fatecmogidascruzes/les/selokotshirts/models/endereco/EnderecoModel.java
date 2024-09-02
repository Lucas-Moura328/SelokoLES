package br.com.fatecmogidascruzes.les.selokotshirts.models.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Enderecos")
public class EnderecoModel extends RepresentationModel<EnderecoModel> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    private String logradouro;

    private int numero;

    private String bairro;

    private String complemento;

    private String cep;

    private String municipio;

    private String estado;

}
