package br.com.fatecmogidascruzes.les.selokotshirts.repositories;

import br.com.fatecmogidascruzes.les.selokotshirts.models.endereco.EnderecoModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {

    /*List<EnderecoModel> findByCliente_id(UUID idCliente);/*/

}
