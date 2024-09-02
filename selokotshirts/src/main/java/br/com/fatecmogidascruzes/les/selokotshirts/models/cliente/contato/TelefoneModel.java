package br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato;

import br.com.fatecmogidascruzes.les.selokotshirts.dtos.ClienteRecordDto;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
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

    @Size(min = 8, max = 9)
    private String telefone;

    public TelefoneModel(String ddd, String telefone) {
        setDdd(ddd);
        setTelefone(telefone);
    }

    public void setDdd(String ddd) {
        String regexDDD = "\\d{2}";
        if (!ddd.matches(regexDDD)){
            System.out.println("Exceção: dever ter 2 digitos");
            //lançar exceção
        } else {
            this.ddd = ddd;
        }

    }

    public void setTelefone(String telefone) {
        String regexTelefone = "\\d{8,9}";
        if(!telefone.matches(regexTelefone)) {
            //lançar exceção
            System.out.println("Exceção: dever ter 8 a 9 digitos");
        } else {
            this.telefone = telefone;
        }

    }

}
