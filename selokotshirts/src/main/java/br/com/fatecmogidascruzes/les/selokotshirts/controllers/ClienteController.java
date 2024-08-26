package br.com.fatecmogidascruzes.les.selokotshirts.controllers;

import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.models.ClienteModel;
import br.com.fatecmogidascruzes.les.selokotshirts.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> listarClientes() {
        List<ClienteModel> clientesList = clienteRepository.findAll();
        if (!clientesList.isEmpty()) {
            for (ClienteModel cliente : clientesList) {
                UUID id = cliente.getIdCliente();
                cliente.add(linkTo(methodOn(ClienteController.class).listarUmCliente(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientesList);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Object> listarUmCliente(@PathVariable(value = "id") UUID id) {
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não Encontrado.");
        }
        clienteO.get().add((linkTo(methodOn(ClienteController.class).listarClientes()).withSelfRel()));
        return ResponseEntity.status(HttpStatus.OK).body(clienteO.get());
    }
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid ClienteRecordDto clienteRecordDto) {
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não Encontrado.");
        }
        var clienteModel = clienteO.get();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));
    }
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable(value = "id") UUID id) {
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não Encontrado.");
        }
        clienteRepository.delete(clienteO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
    }

}
