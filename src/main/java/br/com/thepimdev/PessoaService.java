package br.com.thepimdev;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@ApplicationScoped
public class PessoaService {

    public static final Pessoa pessoa = new Pessoa(
        "ThePimDev",
        "000.000.000-00",
        LocalDate.now(ZoneId.systemDefault()),
        LocalDateTime.now(ZoneId.systemDefault())
    );

    public Pessoa getPessoa() {
        return pessoa;
    }
}
