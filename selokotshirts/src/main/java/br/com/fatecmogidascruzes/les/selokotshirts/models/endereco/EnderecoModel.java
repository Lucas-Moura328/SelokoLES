package br.com.fatecmogidascruzes.les.selokotshirts.models.endereco;

import br.com.fatecmogidascruzes.les.selokotshirts.dtos.EnderecoRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.ClienteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter

@NoArgsConstructor
@Table(name = "Enderecos")
public class EnderecoModel extends RepresentationModel<EnderecoModel> implements Serializable {
    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Setter
    private String logradouro;

    @Setter
    private int numero;

    @Setter
    private String bairro;

    @Setter
    private String complemento;

    @Setter
    private String cep;

    @Setter
    private String municipio;

    @Setter
    private String estado;

    @Setter
    private boolean entrega;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_id",nullable = false, updatable = false)
    private ClienteModel cliente;

    public EnderecoModel(@Valid EnderecoRecordDto endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.bairro = endereco.bairro();
        this.estado = endereco.estado();
        this.entrega = endereco.entrega();
        setCliente(endereco.idCliente());

    }

    public void setCliente(UUID idCliente) {
        ClienteModel clienteModel = new ClienteModel();
        cliente.setIdCliente(idCliente);
        this.cliente = clienteModel;
    }
}
