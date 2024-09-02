package br.com.fatecmogidascruzes.les.selokotshirts.controllers;



import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.dtos.EnderecoRecordDto;
import br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.ClienteModel;
import br.com.fatecmogidascruzes.les.selokotshirts.models.endereco.EnderecoModel;
import br.com.fatecmogidascruzes.les.selokotshirts.repositories.EnderecoRepository;
import br.com.fatecmogidascruzes.les.selokotshirts.services.EnderecoService;
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
@CrossOrigin(maxAge = 3600, origins = "*")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/Enderecos")
    public ResponseEntity<EnderecoModel> salvarEndereco(@RequestBody @Valid EnderecoRecordDto enderecoRecordDto) {
        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(enderecoRecordDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.saveEndereco(enderecoModel));
    }

    @GetMapping("/Enderecos")
    public ResponseEntity<List<EnderecoModel>> listarEnderecos() {
        List<EnderecoModel> enderecoLists = enderecoService.findAll();
        if (!enderecoLists.isEmpty()) {
            for (EnderecoModel endereco : enderecoLists) {
                Long id = endereco.getIdEndereco();
                endereco.add(linkTo(methodOn(EnderecoController.class).listarUmEndereco(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoLists);
    }
    @GetMapping("/Enderecos/{id}")
    public ResponseEntity<Object> listarUmEndereco(@PathVariable(value = "id") Long id) {
        Optional<EnderecoModel> enderecoO = enderecoService.findById(id);
        if(enderecoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco Não Encontrado.");
        }
        enderecoO.get().add((linkTo(methodOn(EnderecoController.class).listarEnderecos()).withSelfRel()));
        return ResponseEntity.status(HttpStatus.OK).body(enderecoO.get());
    }

    @PutMapping("/Enderecos/{id}")
    public ResponseEntity<Object> atualizarEndereço(@PathVariable(value = "id") Long id,
                                                   @RequestBody @Valid EnderecoRecordDto enderecoRecordDto) {
        Optional<EnderecoModel> enderecoO = enderecoService.findById(id);
        if(enderecoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco Não Encontrado.");
        }
        var enderecoModel = enderecoO.get();
        BeanUtils.copyProperties(enderecoRecordDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.saveEndereco(enderecoModel));
    }
    @DeleteMapping("/Enderecos/{id}")
    public ResponseEntity<Object> deletarEndereço(@PathVariable(value = "id") Long id) {
        Optional<EnderecoModel> enderecoO = enderecoService.findById(id);
        if(enderecoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco Não Encontrado.");
        }
        enderecoService.deleteEndereco(enderecoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Endereço removido com sucesso!");
    }

}
