package br.com.fatecmogidascruzes.les.selokotshirts.models;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Clientes")
public class ClienteModel extends RepresentationModel<ClienteModel> implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Getter @Setter
    private UUID idCliente;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String cpf;

    @Getter @Setter
    private LocalDate dataNascimento;

    @Getter @Setter
    private String senha;

    @Getter @Setter
    private boolean ativo;

    @Getter @Setter
    private String email;

}
