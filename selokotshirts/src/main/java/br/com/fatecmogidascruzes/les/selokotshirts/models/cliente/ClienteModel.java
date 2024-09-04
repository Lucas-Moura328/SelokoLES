package br.com.fatecmogidascruzes.les.selokotshirts.models.cliente;


import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.dtos.EnderecoRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.EmailModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.TelefoneModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.endereco.EnderecoModel;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Clientes")
public class ClienteModel extends RepresentationModel<ClienteModel> implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private UUID idCliente;

    @Getter @Setter
    @Size(min = 2, max = 100)
    private String nome;

    @Getter @Setter
    @Size(min = 11, max = 11)
    private String cpf;

    @Getter @Setter
    private LocalDate dataNascimento;

    @Getter @Setter
    @Size(min = 8, max = 50)
    private String senha;

    @Getter @Setter
    private boolean ativo;

    @Getter @Setter
    @Embedded
    private EmailModel email;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private GeneroModel genero;

    @Getter
    @Embedded
    private TelefoneModel telefone;

    @Getter
    @OneToMany(mappedBy = "cliente")
    private List<EnderecoModel> enderecos;


    public void setEnderecos(List<EnderecoRecordDto> enderecos) {
        this.enderecos = enderecos.stream().map(endereco -> new EnderecoModel(endereco)).collect(Collectors.toList());
    }

    /*public ClienteModel (@Valid ClienteRecordDto clienteRecordDto){
        this.nome = clienteRecordDto.nome();
        this.cpf = clienteRecordDto.cpf();
        this.dataNascimento = clienteRecordDto.dataNascimento();
        this.senha = clienteRecordDto.senha();
        this.ativo = clienteRecordDto.ativo();
        this.genero = clienteRecordDto.genero();
        this.telefone = clienteRecordDto.telefone();
        setEnderecos(clienteRecordDto.enderecos());
    }*/

    /*public void setTelefone(ClienteRecordDto clienteRecordDto) {
            this.telefone = new TelefoneModel(clienteRecordDto.ddd(), clienteRecordDto.telefone());
        }*/
    public void setTelefone(TelefoneModel telefone) {
        this.telefone = telefone;
    }

    //public void setIdCliente(UUID idCliente) {
    //    this.idCliente = idCliente;
    //}
}
