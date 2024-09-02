package br.com.fatecmogidascruzes.les.selokotshirts.services;

import br.com.fatecmogidascruzes.les.selokotshirts.models.endereco.EnderecoModel;
import br.com.fatecmogidascruzes.les.selokotshirts.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public EnderecoModel saveEndereco(EnderecoModel enderecoModel) {
        return enderecoRepository.save(enderecoModel);
    }

    public List<EnderecoModel> findAll() {
        return enderecoRepository.findAll();
    }
    public Optional<EnderecoModel> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    @Transactional
    public void deleteEndereco (EnderecoModel enderecoModel){
        enderecoRepository.delete(enderecoModel);
    }
}
