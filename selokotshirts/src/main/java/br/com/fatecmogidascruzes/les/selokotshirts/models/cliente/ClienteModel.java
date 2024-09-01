package br.com.fatecmogidascruzes.les.selokotshirts.models.cliente;

import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.EmailModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato.TelefoneModel;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
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

    @Getter @Setter
    @Embedded
    private TelefoneModel telefone;


    /*public void setTelefone(ClienteRecordDto clienteRecordDto) {
        this.telefone = new TelefoneModel(clienteRecordDto.ddd(), clienteRecordDto.telefone());
    }

    public void setTelefone(TelefoneModel telefone) {
        this.telefone = telefone;
    }*/
}
