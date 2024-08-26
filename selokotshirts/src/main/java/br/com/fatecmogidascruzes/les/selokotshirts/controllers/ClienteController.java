package br.com.fatecmogidascruzes.les.selokotshirts.controllers;

import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.models.ClienteModel;
import br.com.fatecmogidascruzes.les.selokotshirts.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }


}
