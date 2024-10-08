package br.com.fatecmogidascruzes.les.selokotshirts.repositories;

import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
}
