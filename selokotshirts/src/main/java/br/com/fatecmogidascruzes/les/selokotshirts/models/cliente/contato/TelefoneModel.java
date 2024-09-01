package br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato;

import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Embeddable
public class TelefoneModel {
    public static final int VERIFY_DDD = 2;
    private String ddd;

    private String telefone;

    public TelefoneModel(ClienteRecordDto clienteRecordDto) {
        setDdd(clienteRecordDto.ddd());
        setTelefone(clienteRecordDto.telefone());
    }

    public void setDdd(String ddd) {
        String regexDDD = "\\d{2}";
        if (!ddd.matches(regexDDD)){

        }
        this.ddd = ddd;
    }

    public void setTelefone(String telefone) {
        String regexTelefone = "\\d{8,9}";
        if(!telefone.matches(regexTelefone)) {

        }
        this.telefone = telefone;
    }

}
