package br.com.thepimdev;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
record Pessoa(String nome, String cpf, LocalDate nascimento, LocalDateTime criacao) {}
