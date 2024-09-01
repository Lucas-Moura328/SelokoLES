package br.com.fatecmogidascruzes.les.selokotshirts.models.cliente.contato;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
@Embeddable
public class EmailModel {

    private String email;

    public EmailModel(String email) {
        setEmail(email);
    }

    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {

        }

        this.email = email.trim().toLowerCase();
    }
}
