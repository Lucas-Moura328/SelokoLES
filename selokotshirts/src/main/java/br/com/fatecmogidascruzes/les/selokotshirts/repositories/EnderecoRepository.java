package br.com.fatecmogidascruzes.les.selokotshirts.repositories;

import br.com.fatecmogidascruzes.les.selokotshirts.models.endereco.EnderecoModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
