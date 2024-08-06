package br.com.thepimdev;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("pessoa")
public class PessoaResource {

    @Inject
    private PessoaService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa pessoa() {
        return service.getPessoa();
    }
}

